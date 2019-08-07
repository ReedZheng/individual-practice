package practicecourt.offer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 自己的思路类似之前的求 abcd 的全排列，暴力解法吧..
 *
 * 牛客上的解析： 比较两个字符串 s1, s2 大小的时候，先将它们拼接起来，
 * 比较 s1+s2 和 s2+s1 那个大，如果 s1+s2 大，那说明 s2 应该放前面，所以按这个规则，s2 就应该排在 s1 前面。
 */
public class Off035 {
    public String printMinNumber(int[] numbers) {
        if (numbers.length < 1) {
            return "";
        }

        ArrayList<String> list = new ArrayList<>();
        getAllArrangement(numbers, list, 0);

        BigDecimal min = new BigDecimal("999999999999999");
        for (String s : list) {
            BigDecimal tmp = new BigDecimal(s);
            if (min.compareTo(tmp) > 0) {
                min = tmp;
            }
        }

        return String.valueOf(min);
    }

    private void getAllArrangement(int[] numbers, ArrayList<String> list, int i) {
        if (i == numbers.length - 1) {
            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                sb.append(number);
            }
            list.add(sb.toString());
        }
        for (int j = i; j < numbers.length; j++) {
            swap(numbers, i, j);
            getAllArrangement(numbers, list, i + 1);
            swap(numbers, i, j);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    /**
     * from 牛客
     * 比较 s1+s2 和 s2+s1 哪个大，如果 s1+s2 大，那说明 s2 应该放前面，所以按这个规则进行排序最后拼接
     *
     * @param numbers
     * @return
     */
    public String printMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        //
        Arrays.sort(str, (s1, s2) -> {
            String c1 = s1 + s2;
            String c2 = s2 + s1;
            return c1.compareTo(c2);
        });

        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }
}
