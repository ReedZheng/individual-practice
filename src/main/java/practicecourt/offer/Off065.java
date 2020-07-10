package practicecourt.offer;

import java.util.ArrayList;
import practicecourt.offer.assistant.TreeNode2;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如（5，3，7，2，4，6，8）中， 按结点数值大小顺序第三小结点的值为4。
 */
public class Off065 {

    TreeNode2 kthNode(TreeNode2 pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        // 中序，存进链表
        ArrayList<TreeNode2> list = new ArrayList<>();

        traverse(pRoot, list);

        if (k > list.size()) {
            return null;
        }

        return list.get(k - 1);
    }

    private void traverse(TreeNode2 node, ArrayList<TreeNode2> list) {
        if (node == null) {
            return;
        }

        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);

    }
}
