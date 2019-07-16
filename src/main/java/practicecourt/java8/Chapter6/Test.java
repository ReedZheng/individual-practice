package practicecourt.java8.Chapter6;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        Transaction t1 = new Transaction("AM", new Currency("DOLLAR", 1100), true);
        Transaction t2 = new Transaction("HK", new Currency("HKD", 900), false);
        Transaction t3 = new Transaction("GD", new Currency("RMB", 1800), false);
        Transaction t4 = new Transaction("GD", new Currency("DOLLAR", 100), false);

        List<Transaction> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);

        // 分组并对每一组进行求和 [单级分组]
        Map<String, Integer> collect = list.stream().map(item -> item.getAmount()).collect(
                groupingBy(Currency::getType, summingInt(Currency::getAmountDisplayed)));
        System.out.println(collect);
        System.out.println("--------------------------------");
        // [单级分组，贵与不贵]
        Map<String, List<Currency>> collect1 = list.stream().map(item -> item.getAmount()).collect(groupingBy(item -> {
            if (item.getAmountDisplayed() < 500) {
                return "cheap";
            } else if (500 <= item.getAmountDisplayed() && item.getAmountDisplayed() < 1000) {
                return "ok";
            } else {
                return "expensive";
            }
        }));
        System.out.println(collect1);
        // [多级分组，先按地址分再按贵不贵分]
        Map<String, Map<String, List<Transaction>>> collect2 =
                list.stream().collect(groupingBy(Transaction::getTransactionAddr, groupingBy(item -> {
                    if (item.getAmount().getAmountDisplayed() < 500) {
                        return "cheap";
                    } else if (500 <= item.getAmount().getAmountDisplayed()
                            && item.getAmount().getAmountDisplayed() < 1000) {
                        return "ok";
                    } else {
                        return "expensive";
                    }
                })));
        System.out.println(collect2);

        System.out.println("--------------------------------");
        // 汇总
        IntSummaryStatistics a =
                list.stream().map(item -> item.getAmount()).collect(summarizingInt(Currency::getAmountDisplayed));
        System.out.println(a);
        // 使用reducing计算总和
        Integer sum = list.stream().map(item -> item.getAmount())
                          .collect(reducing(0, Currency::getAmountDisplayed, Integer::sum));
        System.out.println(sum);

        // 连接字符串
        String str = list.stream().map(item -> item.getAmount().getType()).collect(joining(","));
        System.out.println(str);

        // groupingBy 和 mapping
        Map<String, Set<String>> collect3 = list.stream().collect(groupingBy(Transaction::getTransactionAddr, mapping(item -> {
            if ("DOLLAR".equals(item.getAmount().getType())) {
                return "DOLLAR";
            } else if ("HKD".equals(item.getAmount().getType())) {
                return "HKD";
            } else {
                return "RMB";
            }
        }, toSet())));
        System.out.println(collect3);

        // 分区
        Map<Boolean, List<Transaction>> collect4 = list.stream().collect(partitioningBy(Transaction::getSuccess));
        System.out.println(collect4);
        System.out.println(collect4.get(true));

        // 判断是不是素数
        boolean b = IntStream.rangeClosed(2, 20)
                             .noneMatch(i -> 20 % i == 0);
        System.out.println(b);


    }
}
