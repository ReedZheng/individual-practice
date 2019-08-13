package practicecourt.offer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class Off052 {
    public int strToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }

        int len = str.length();
        int result = 0;
        boolean flag = false;

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            int tmp = c - '0';

            if (tmp >= 0 && tmp <= 9) {
                result = result * 10 + tmp;
            } else {
                if (i != 0) {
                    flag = true;
                }
            }
        }

        if (flag) {
            return 0;
        }

        return str.charAt(0) == '-' ? -1 * result : result;
    }

    public static void main(String[] args) {
        System.out.println(new Off052().strToInt("2147483649"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
