package practicecourt.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级，也可以跳上3级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 分别计算1级，2级，3级，4级台阶总结出规律，得出答案
 */
public class Off012 {

    public int jumpFloorII(int target) {
        if (target < 2) {
            return 1;
        }

        return (int)Math.pow(2, target - 1);
    }
}
