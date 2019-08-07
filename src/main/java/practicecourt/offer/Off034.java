package practicecourt.offer;

/**
 * 题目描述
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 时间复杂度太高。。
 */
public class Off034 {
    public int numberOf1Between1AndNSolution(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += calculate(i);
        }
        return count;
    }

    public int calculate(int n) {
        int count = 0;

        while (n > 0) {
            if (n % 10 == 1) {
                count++;
            }
            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Off034().numberOf1Between1AndNSolution(100000));
    }
}


