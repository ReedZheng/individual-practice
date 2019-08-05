package practicecourt.offer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 大/小顶堆，注意：并不能由大/小顶堆直接得到数组中最大/小的元素。
 * 如：
 *      2
 *    /   \
 *   9     4
 *  / \   / \
 * 11 12 5   6
 * 思路：将前k个元素构造成大顶堆，然后将后续的元素a依次与大顶堆中最大的元素对比，若a小于最大元素则删除最大的元素并插入a，
 * 否则不做其他操作。
 *
 * java中的优先队列是基于堆实现的，因此也可以使用PriorityQueue
 */
public class Off032 {
    public ArrayList<Integer> getLeastNumbersSolution(int[] input, int k) {
        if (input.length <= 0 || k <= 0 || k > input.length) {
            return new ArrayList<>();
        }

        int[] max = new int[k];
        for (int i = 0; i < k; i++) {
            max[i] = input[i];
        }
        build(max);

        for (int i = k - 1; i < input.length; i++) {
            if (max[0] > input[i]) {
                max[0] = input[i];
                build(max);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < max.length; i++) {
            list.add(max[i]);
        }

        return list;
    }

    public void build(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int biggest = i;

        if (left < arr.length && arr[left] > arr[biggest]) {
            biggest = left;
        }

        if (right < arr.length && arr[right] > arr[biggest]) {
            biggest = right;
        }

        if (biggest == i) {
            return;
        }

        swap(arr, i, biggest);
        heapify(arr, biggest);
    }

    private int getLeft(int i) {
        return i * 2 + 1;
    }

    private int getRight(int i) {
        return i * 2 + 2;
    }

    private void swap(int[] arr, int originIndex, int newIndex) {
        int old = arr[originIndex];
        arr[originIndex] = arr[newIndex];
        arr[newIndex] = old;
    }
}
