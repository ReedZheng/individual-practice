package practicecourt.offer;

import lombok.extern.slf4j.Slf4j;

/**
 * 从头到尾扫描整个数组中的数字，当扫描到下标为i的数字时， 首先比较这个数字（用m表示）是不是等于下标i，如果是，接着比较下一个数字；
 * 如果不是，则将其与第m个数字比较，若与第m个数字相同，则说明它就是一个重复数字；如果不同，就将其与第m个数字进行交换，也就是把它放到自己应在的位置去。
 * 重复这个过程，直到该位置上的数与下标相同为止。
 * 不是剑指offer的题
 */
@Slf4j
public class Other003 {

    public int resolve(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }

        int val;
        for (int i = 0; i < arr.length; i++) {
            val = arr[i];
            while (val != i) {
                if (val != arr[val]) {
                    arr[i] = arr[val];
                    arr[val] = val;
                } else {
                    return val;
                }
                val = arr[i];
            }
        }
        return -1;
    }

    // from https://github.com/CyC2018/CS-Notes/blob/master/notes/
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    log.info("找到的重复数字是：{}", duplication[0]);
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
