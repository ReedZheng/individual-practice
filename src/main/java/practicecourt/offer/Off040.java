package practicecourt.offer;

/**
 * 统计一个数字在排序数组中出现的次数。 二分法
 */
public class Off040 {

    public int getNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }

        int count = 0, left = 0, right = array.length - 1, mid = left + (right - left) / 2;
        int tmp;

        while (left <= right) {
            if (array[mid] > k) {
                right = mid - 1;
                mid = left + (right - left) / 2;

            } else if (array[mid] < k) {
                left = mid + 1;
                mid = left + (right - left) / 2;

            } else {
                tmp = mid;
                while (tmp >= 0 && array[tmp--] == k) {
                    count++;
                }
                while (++mid <= right && array[mid] == k) {
                    count++;
                }
                break;

            }
        }

        return count;
    }
}


