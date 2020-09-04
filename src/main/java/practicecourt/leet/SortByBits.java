package practicecourt.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 【1356. 根据数字二进制下 1 的数目排序】 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。 请你返回排序后的数组。
 *
 * @Author: zhengfenghong
 * @Date: 2020/7/14 17:47
 */
public class SortByBits {

    public static void main(String[] args) {
        SortByBits s = new SortByBits();
        int[] a = s.sortByBits(new int[]{130, 42, 141, 7, 16, 5, 990, 109, 304, 112});
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>(Integer::compareTo);
        int[] result = new int[arr.length];

        for (int value : arr) {
            int count = compute1(value);
            if (map.get(count) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(count, list);
            } else {
                List<Integer> list = map.get(count);
                list.add(value);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (List<Integer> values : map.values()) {
            values.sort(Integer::compareTo);
            list.addAll(values);
        }

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private static int compute1(int num) {
        int count = 0;
        while (num != 0) {
            // 判断 num 的二进制表示中的最后一位是否为 1
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

}
