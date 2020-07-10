package practicecourt.leet;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same
 * backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121 Output: true Example 2:
 * <p>
 * Input: -121 Output: false Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome. Example 3:
 * <p>
 * Input: 10 Output: false Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 */
public class PalindromeNumber {

    /**
     * Second idea would be reverting the number itself, and then compare the number with original
     * number, if they are the same, then the number is a palindrome. However, if the reversed
     * number is larger than int.MAX, we will hit integer overflow problem. 这种写法当 x 为
     * Integer.MAX_VALUE 时会出现反转的数溢出！！
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int sum = 0;
        int origin = x;

        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }

        return sum == origin;
    }

    /**
     * from leetcode
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        // 右边部分的判断把所有以 0 结尾的数字直接判为 false，例：10 反转后变为 01 即 1，判为 false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int first = x, last = 0;

        while (first >= last) {
            if (first == last || last == first / 10) {
                return true;
            }
            last = last * 10 + first % 10;
            first /= 10;
        }

        return false;
    }
}
