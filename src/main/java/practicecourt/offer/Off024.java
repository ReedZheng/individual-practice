package practicecourt.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。 （注意：这两个序列的长度是相等的） 牛客网上 Alias 的做法更好
 */
public class Off024 {

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }

        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        // 将入栈的数字放在两个辅助栈里边，in 表示已经入真正的栈， out 表示还未入真正的栈
        // 将第一个出栈的数字以及之前的数字放到 in 中，将第一个出栈的数字后的数字放到 out 中
        for (int i = 0; i < pushA.length; i++) {
            in.push(pushA[i]);
            if (pushA[i] == popA[0] && i < pushA.length - 1) {
                for (int j = pushA.length - 1; j > i; j--) {
                    out.push(pushA[j]);
                }
                break;
            }
        }

        // 如果 in 的栈顶元素与当前要出栈的元素一致的话则出栈继续做下一次判断，否则，看看 out 里边有没有元素，
        // 若有，将其压入 in 中，再次做一致判断；若无说明不可能是弹出序列
        for (int i = 0; i < popA.length; i++) {
            if (!in.empty() && in.peek() == popA[i]) {
                in.pop();
            } else {
                if (!out.empty()) {
                    in.push(out.pop());
                    i--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
