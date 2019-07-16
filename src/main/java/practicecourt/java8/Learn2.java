package practicecourt.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Date: 2018/12/5
 */
public class Learn2 {
    public static void main(String[] args) {
        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(1);
        integerList1.add(3);
        integerList1.add(4);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1);
        integerList2.add(2);

        // flatMap()让一个流中的每个值都变成另一个流
        List<int[]> collect = integerList1.stream()
                                          .flatMap(i -> integerList2.stream().map(j -> new int[]{i, j}))
                                          .filter(item -> item[0] * item[1] % 3 == 0)
                                          .collect(Collectors.toList());
        for (int[] a : collect) {
            System.out.print("(" + a[0] + ", " + a[1] + ") ");
        }
        System.out.println();
        System.out.println("-----------------");
        boolean b = integerList1.stream().anyMatch(item -> item % 2 == 0);
        System.out.println(b);
        boolean c = integerList1.stream().allMatch(item -> item % 2 == 0);
        System.out.println(c);
        boolean d = integerList1.stream().noneMatch(item -> item % 2 == 0);
        System.out.println(d);
        System.out.println("-----------------");

        Optional<Integer> any = integerList2.stream().filter(item -> item % 2 == 0).findAny();
        any.ifPresent(item -> System.out.println("找到符合条件的值:" + item));
        System.out.println("-----------------");

        Integer reduce = integerList1.stream().reduce(0, (var1, var2) -> var1 + var2);
        System.out.println(reduce);
        System.out.println("-----------------");

        long count = integerList1.stream().count();
        Integer count2 = integerList1.stream().map(item -> 1).reduce(0, Integer::sum);
        System.out.println(count + " - " + count2);

    }
}
