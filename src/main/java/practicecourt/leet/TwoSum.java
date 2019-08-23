package practicecourt.leet;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution, and you may not use the
 * same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        // 37 ms
        // int[] result = new int[2];
        // for (int i = 0; i < nums.length; i++) {
        //     int left = target - nums[i];
        //
        //     for (int j = 0; j < nums.length; j++) {
        //         if (i == j) {
        //             continue;
        //         }
        //         if (nums[j] == left) {
        //             result[0] = i;
        //             result[1] = j;
        //             return result;
        //         }
        //     }
        // }

        // 2ms
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[] {i, map.get(tmp)};
            }
        }

        return null;
    }
}
