package practicecourt.offer;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Off016 {

    public void reOrderArray(int[] array) {
        LinkedBlockingQueue<Integer> odds = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<Integer> evens = new LinkedBlockingQueue<>();

        for (int i : array) {
            try {
                if ((i & 1) == 0) {
                    evens.put(i);
                } else {
                    odds.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int index = 0;

        for (Integer odd : odds) {
            array[index++] = odd;
        }

        for (Integer even : evens) {
            array[index++] = even;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
