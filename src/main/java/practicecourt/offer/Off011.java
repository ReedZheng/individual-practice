package practicecourt.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。 跟斐波那契数列一样 兔子繁殖问题 换硬币问题 -- 动态规划。。
 */
public class Off011 {

    public int jumpFloor(int target) {
        if (target < 2) {
            return target;
        }

        int a = 1;
        int b = 2;
        int result = 2;

        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
