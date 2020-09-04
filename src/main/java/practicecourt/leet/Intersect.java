package practicecourt.leet;

/**
 * 【350. 两个数组的交集 II】
 * 两个数组的交集 II 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 更好的解法：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
 *
 * @Author: zhengfenghong
 * @Date: 2020/7/13 13:54
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] longArr, shortArr;

        if (nums1.length > nums2.length) {
            longArr = nums1;
            shortArr = nums2;
        } else {
            shortArr = nums1;
            longArr = nums2;
        }

        byte[] flag = new byte[longArr.length];
        int k = 0;

        for (int value : shortArr) {
            for (int i = 0; i < longArr.length; i++) {
                if (value == longArr[i] && flag[i] == (byte) 0) {
                    // 标识为已使用
                    flag[i] = (byte) 1;
                    k++;
                    break;
                }
            }
        }

        int[] result = new int[k];
        for (int i = 0, j = 0; i < flag.length; i++) {
            if (flag[i] == (byte) 1) {
                result[j++] = longArr[i];
            }
        }

        return result;
    }
}
