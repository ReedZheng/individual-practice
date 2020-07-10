package practicecourt.leet;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Input: 123 Output: 321 Input: -123 Output: -321 Input: 120 Output: 21
 * <p>
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your
 * function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }

        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) sum;
    }
}
