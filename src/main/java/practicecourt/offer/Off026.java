package practicecourt.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * 自己给出的结论：后序遍历（左->右->根），因此最末尾一个数字是二叉树的根。
 * 在数组中找到比根小的节点，剩下的节点的值就必然比根节点的值大，
 * 若不成立，则该数组序列不可能是二叉树后序遍历的结果。
 * 结论是否成立？？还是说只是通过了牛客的测试用例而已？
 */
public class Off026 {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length < 1) {
            return false;
        }

        int len = sequence.length;
        int last = sequence[len - 1];
        int breakPoint = 0;

        while (sequence[breakPoint] < last) {
            breakPoint++;
        }
        for (int i = breakPoint; i < len - 1; i++) {
            if (sequence[i] < last) {
                return false;
            }
        }
        return true;
    }
}

