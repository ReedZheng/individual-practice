package practicecourt.offer;

import java.math.BigDecimal;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * <p>
 * 快速幂的方式： a^n 表示 a^(n的二进制表示) 例： 5^15 表示 5^(1111) 计算二进制的最左边一位数字1与最后一位数字的距离差（程序中用while加上>>进行计算），
 * 这里第一位1是4，最后一位数字是1，4-1=3， 因此 5^15 -> (((5²)²)²)*(5^7) （最后*5的次数取决于上边那段距离（即111）的十进制表示（即7）程序中if块处理这个逻辑）
 * <p>
 * 快速幂不能直接处理负数
 */
public class Off015 {

    public double power(double base, int exponent) {

        BigDecimal num = new BigDecimal(String.valueOf(base));
        BigDecimal result = BigDecimal.ONE;
        boolean isNegative = false;

        if (exponent < 0) {
            isNegative = true;
            exponent *= -1;
        }

        for (int i = 0; i < exponent; i++) {
            result = result.multiply(num);
        }

        double v = result.doubleValue();
        return isNegative ? 1 / v : v;
    }

    /**
     * 快速幂
     */
    public double otherMethod(double base, int exponent) {
        double result = 1.0;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent *= -1;
            isNegative = true;
        }

        while (exponent != 0) {
            if ((exponent & 1) != 0) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }

        return isNegative ? 1 / result : result;
    }
}
