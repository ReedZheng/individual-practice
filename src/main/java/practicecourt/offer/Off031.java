package practicecourt.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Off031 {
    public int moreThanHalfNumSolution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(16);
        Integer count;
        int halfOfTheArray = array.length >> 1;

        for (int i : array) {
            if ((count = map.get(i)) != null) {
                map.put(i, count + 1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > halfOfTheArray) {
                return i;
            }
        }

        return 0;
    }

    /**
     * 摩尔投票法（也叫打擂算法）
     *
     * @param numbers
     * @return
     */
    int moreThanHalfNumSolution2(int[] numbers) {
        int num = numbers[0], cnt = 1;

        // 找出重复次数最多的元素
        for (int i = 1; i < numbers.length; ++i) {
            if (numbers[i] == num) {
                cnt++;
            } else {
                if (--cnt == 0) {
                    cnt = 1;
                    num = numbers[i];
                }
            }
        }

        // 重新计算该元素在数组中出现的次数
        cnt = 0;
        for (int number : numbers) {
            if (number == num) {
                cnt++;
            }
        }

        if (2 * cnt > numbers.length) {
            return num;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 2, 4, 2, 3, 2, 2, 1};
        System.out.println(new Off031().moreThanHalfNumSolution(array));
        System.out.println(new Off031().moreThanHalfNumSolution2(array));
    }
}
