package practicecourt.offer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数将num1[0],num2[0]设置为返回结果
 */
public class Off043 {
    public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array.length < 1) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            } else {
                map.put(i, 1);
            }
        }

        List<Integer> list = map.entrySet().stream().filter(item -> item.getValue() == 0).map(Map.Entry::getKey)
            .collect(Collectors.toList());
        if (list.size() == 2) {
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
    }

    /**
     * 1、异或思想，一个数与自己异或为0，一个数与0异或为自己
     * 2、由于其它数字两两相同，所以所有数异或则得到这两个不同数的异或结果。取这个结果的第一个1作为标志位
     * 3、这个标志的1，必须是：这两个数在该位一个为0，一个为1
     * 4、这样可以将数组分为两组，一组在该标志位为1，一组在该标志位为0，这两个不同数字分别在这两组内
     * 5、将两组内的数分别异或，得到两个结果则为这两个不同的数
     * 看不懂。。
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void findNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
        int num = 0;
        for (int i2 : array) {
            // 所有数异或，结果为不同的两个数字的异或
            num ^= i2;
        }

        // 标志位，记录num中的第一个1出现的位置
        int count = 0;
        for (; count < array.length; count++) {
            if ((num & (1 << count)) != 0) {
                break;
            }
        }

        num1[0] = 0;
        num2[0] = 0;

        for (int i1 : array) {
            // 标志位为0的为一组，异或后必得到一个数字（这里注意==的优先级高于&，需在前面加（））
            if ((i1 & (1 << count)) == 0) {
                num1[0] ^= i1;
            } else {
                // 标志位为1的为一组
                num2[0] ^= i1;
            }
        }
    }
}
