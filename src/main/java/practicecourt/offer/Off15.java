package practicecourt.offer;

import java.math.BigDecimal;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 可以用快速幂的方式
 */
public class Off15 {
    public static double Power(double base, int exponent) {

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

    public static void main(String[] args) {
        System.out.println(Power(2,-3));
    }
}
