package practicecourt.offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 不会。。看了牛客，说是用递归以及短路与的特性，用递归实现了累加
 */
public class Off050 {
    public int sumSolution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += sumSolution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Off050().sumSolution(50));
    }
}
