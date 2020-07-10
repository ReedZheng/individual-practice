package practicecourt.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S， 输出两个数的乘积最小的。 对应每个测试案例，输出两个数，小的先输出。
 * <p>
 * 重点：a+b=sum,a 和 b 越远乘积越小！
 */
public class Off045 {

    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();

        if (array.length < 2) {
            return list;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, 1);
        }

        int j, k;
        for (int i = 0; i < array.length / 2; i++) {
            j = array[i];
            k = sum - array[i];
            if (map.containsKey(k)) {
                list.add(j);
                list.add(k);
                break;
            }
        }

        return list;
    }

    /**
     * from 牛客，a+b=sum,a 和 b 越远乘积越小！
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }

        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;
    }
}
