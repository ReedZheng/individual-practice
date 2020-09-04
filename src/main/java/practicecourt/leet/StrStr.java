package practicecourt.leet;

/**
 * 【28. 实现 strStr()】
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。 当
 * needle 是空字符串时返回 0。
 * <p>
 * 目标：学习 Sunday 算法，学习 String 源码如 contains，indexOf 等 https://www.cnblogs.com/zhaosq/p/10578459.html
 *
 * @Author: zhengfenghong
 * @Date: 2020/7/13 10:25
 */
public class StrStr {

    public int strStr(String haystack, String needle) {

        int nLength, hLength = haystack.length();
        if (needle == null || (nLength = needle.length()) == 0) {
            return 0;
        }

        int index = -1;

        for (int i = 0, j = 0; i <= hLength - nLength; i++, j++) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                // 回到 needle 字符串首位
                j = -1;
                continue;
            }

            index = i;
            for (; j < nLength; i++, j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    // 恢复 i 的值
                    i = index;
                    // 标识为未找到
                    index = -1;
                    // 回到 needle 字符串首位
                    j = -1;
                    break;
                }
            }
            // 匹配成功，退出外部循环
            if (index > -1) {
                break;
            }
        }

        return index;
    }
}
