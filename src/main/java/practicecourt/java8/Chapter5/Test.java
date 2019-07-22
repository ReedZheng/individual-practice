package practicecourt.java8.Chapter5;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description:
 * @Date: 2018/12/6
 */
public class Test {
    public static void main(String[] args) {
        Traders t1 = new Traders("Raoul", "Cambridge");
        Traders t2 = new Traders("Mario", "Milan");
        Traders t3 = new Traders("Alan", "Cambridge");
        Traders t4 = new Traders("Brain", "Cambridge");

        Transaction transaction1 = new Transaction("2011", new BigDecimal(300), t4);
        Transaction transaction2 = new Transaction("2012", new BigDecimal(1000), t1);
        Transaction transaction3 = new Transaction("2011", new BigDecimal(400), t1);
        Transaction transaction4 = new Transaction("2012", new BigDecimal(710), t2);
        Transaction transaction5 = new Transaction("2012", new BigDecimal(700), t2);
        Transaction transaction6 = new Transaction("2012", new BigDecimal(950), t3);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
        transactions.add(transaction6);

        Stream<Transaction> stream = transactions.stream();
        // (1)
        List<Transaction> collect1 = stream.filter(item -> "2011".equals(item.getTransactionDate()))
            .sorted(Comparator.comparing(Transaction::getTransactionAmount)).collect(Collectors.toList());
        System.out.println(collect1);

        // (2)
        stream = transactions.stream();
        List<String> collect2 = stream.map(item -> item.getTraders().getCity()).distinct().collect(Collectors.toList());
        System.out.println(collect2);

        // (3)
        stream = transactions.stream();
        List<Traders> collect3 =
            stream.map(item -> item.getTraders()).filter(item -> "Cambridge".equals(item.getCity()))
                .sorted(Comparator.comparing(Traders::getName)).collect(Collectors.toList());
        System.out.println(collect3);

        // (4)
        stream = transactions.stream();
        String reduce1 =
            stream.map(item -> item.getTraders().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(reduce1);

        // (5)
        stream = transactions.stream();
        Optional<Traders> any =
            stream.map(item -> item.getTraders()).filter(item -> "Milan".equals(item.getCity())).findAny();
        any.ifPresent(i -> System.out.println("true"));

        // (6)
        System.out.println("----------------");
        stream = transactions.stream();
        stream.filter(item -> "Cambridge".equals(item.getTraders().getCity())).map(item -> item.getTransactionAmount())
            .forEach(System.out::println);
        System.out.println("----------------");

        // (7)
        stream = transactions.stream();
        Optional<BigDecimal> reduce = stream.map(item -> item.getTransactionAmount()).reduce(BigDecimal::min);
        reduce.ifPresent(System.out::println);

        // test
        List<Integer> integers = Arrays.asList(22, 3, 4, 5, 67, 1, 9, 14);
        int sum = integers.stream().mapToInt(item -> item).sum();
        System.out.println(sum);
        Stream<Integer> boxed = integers.stream().mapToInt(item -> item).boxed();
        boxed.forEach(System.out::println);
        OptionalInt max = integers.stream().mapToInt(item -> item).max();
        max.ifPresent(item -> System.out.println("最大值为：" + item));

        IntStream intStream = IntStream.rangeClosed(1, 10).filter(item -> item % 2 == 0);
        intStream.forEach(System.out::println);
        System.out.println("-------------------");

        // 由值创建流
        Stream<String> stringStream = Stream.of("Hello", "Boys", "and", "Grils");
        stringStream.map(String::toUpperCase).map(item -> item + " ").forEach(System.out::print);
        System.out.println("---------------------");
        // 数组创建流
        Arrays.stream(new int[] {99, 90, -2, 32, 11, -20, 33}).sorted().forEach(System.out::println);
        System.out.println("---------------------");
        // 由文件生成流
        try (Stream<String> fileLines = Files.lines(Paths.get("G:\\11.txt"), Charset.defaultCharset())) {
            fileLines.flatMap(item -> Arrays.stream(item.split(" "))).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 无限流，用limit进行限制
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
        Stream.iterate(new int[] {1, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10).map(item -> item[0])
            .forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("---------------------");
        IntStream.generate(new IntSupplier() {
            int a = 0, b = 1;

            @Override
            public int getAsInt() {
                int temp = b;
                b = a + b;
                a = temp;
                return a;
            }
        }).limit(10).forEach(i -> System.out.print(i + " "));
    }
}
