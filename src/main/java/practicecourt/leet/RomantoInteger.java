package practicecourt.leet;

/**
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * leetcode 上有人用 hashmap 解决
 *
 */
public class RomantoInteger {

    public int romanToInt(String s) {
        int sum = 0;
        int len;

        if (s == null || (len = s.length()) <= 0) {
            return sum;
        }

        String str = "IVXLCDM";
        char c1, c2 = 'I';
        int c1Index, c2Index;

        for (int i = 0; i < len; i++) {
            boolean inBound = (i + 1 < len);

            c1 = s.charAt(i);
            if (inBound) {
                c2 = s.charAt(i + 1);
            }

            // 当出现其他字符时，直接返回 0
            c1Index = str.indexOf(c1);
            c2Index = str.indexOf(c2);
            if (c1Index == -1 || c2Index == -1) {
                return 0;
            }

            // 小的出现在前边
            if (inBound && c1Index < c2Index) {
                sum = sum + getValue(c2) - getValue(c1);
                i++;
            } else {
                sum += getValue(c1);
            }
        }

        return sum;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
