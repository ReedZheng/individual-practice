package practicecourt.offer;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 动态规划？？参考牛客才有思路。。
 */
public class Off036 {

    public int getUglyNumberSolution(int index) {
        if (index < 1) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i = 0, j = 0, k = 0, num = 1;
        int mi = 0, mj = 0, mk = 0;
        int min = 0;

        while (num < index) {
            mi = list.get(i) * 2;
            mj = list.get(j) * 3;
            mk = list.get(k) * 5;

            min = mi > mj ? (mj > mk ? mk : mj) : (mi > mk ? mk : mi);
            list.add(min);

            if (min == mi) {
                i++;
            }
            if (min == mj) {
                j++;
            }
            if (min == mk) {
                k++;
            }

            num++;
        }

        return list.get(list.size() - 1);
    }
}


