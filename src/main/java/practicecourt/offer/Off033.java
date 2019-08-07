package practicecourt.offer;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * <p>
 * 可以用分治或者动态规划（dp）的思想去解决，参考网上
 */
public class Off033 {
    // 从第一位数字开始累加，记录累加过程中出现的最大值并且在连续子序列的和为负时移到数组的下一位重新开始累加直至结束
    public static int findGreatestSumOfSubArray(int[] array) {
        int maxsum, maxhere;
        // 初始化最大和为a[0]
        maxsum = maxhere = array[0];
        int startIndex = 0, endIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (maxhere <= 0) {
                // 如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
                maxhere = array[i];
                if (maxhere > maxsum) {
                    startIndex = i;
                }
            } else {
                // 如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
                maxhere += array[i];
            }
            // 更新最大连续子序列和
            if (maxhere > maxsum) {
                maxsum = maxhere;
                endIndex = i;
            }
        }
        System.out.println("startIndex = " + startIndex + ", endIndex = " + endIndex);
        return maxsum;
    }

    public static void main(String[] args) {
        System.out.println(findGreatestSumOfSubArray(new int[] {1, 1, 1, -2, 1, 3, -4, 1}));
    }
}

