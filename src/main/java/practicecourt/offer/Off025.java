package practicecourt.offer;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import practicecourt.offer.assistant.TreeNode;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印，层序遍历
 */
public class Off025 {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        try {
            if (root != null) {
                queue.put(root);
            }
            TreeNode node;

            while (!queue.isEmpty()) {
                node = queue.poll();
                list.add(Integer.valueOf(node.getVal()));

                if (node.getLeft() != null) {
                    queue.put(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.put(node.getRight());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return list;
    }
}
