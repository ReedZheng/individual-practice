package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
 * 以 ！表示一个结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 叶子结点的左右子节点需要用'#'表示
 */
public class Off064 {

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    String serialize(TreeNode2 root) {
        if (root == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        TreeNode2 node = root;
        Stack<TreeNode2> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                sb.append(node.val).append("!");
                stack.push(node);
                node = node.left;
            }

            TreeNode2 pop = stack.pop();

            if (pop.left == null && pop.right == null) {
                sb.append("#!#!");
            } else if (pop.left != null && pop.right == null) {
                sb.append("#!");
            } else if (pop.right != null && pop.left == null) {
                sb.append("#!");
            }

            if (pop.right != null) {
                node = pop.right;
            }
        }

        return sb.toString();
    }

    /**
     * 前序遍历递归版本
     */
    String serialize3(TreeNode2 root) {
        if (root == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        traversal(root, sb);

        return sb.toString();
    }

    private void traversal(TreeNode2 node, StringBuffer sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val).append("!");

        if (node.left == null) {
            sb.append("#!");
        }
        traversal(node.left, sb);

        if (node.right == null) {
            sb.append("#!");
        }
        traversal(node.right, sb);
    }

    /**
     * 中序遍历
     */
    String serialize2(TreeNode2 root) {
        if (root == null) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        TreeNode2 node = root;
        Stack<TreeNode2> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            TreeNode2 pop = stack.pop();

            if (pop.left == null) {
                sb.append("#!");
            }
            sb.append(pop.val).append("!");
            if (pop.right == null) {
                sb.append("#!");
            }

            if (pop.right != null) {
                node = pop.right;
            }
        }

        return sb.toString();
    }

    /**
     * from 牛客
     *
     * @param str
     * @return
     */
    TreeNode2 deserialize(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }

        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, str.split("!"));
        return deserialize(queue);
    }

    private TreeNode2 deserialize(Queue<String> queue) {
        String string = queue.poll();
        if (string.equals("#")) {
            return null;
        }
        TreeNode2 root = new TreeNode2(Integer.parseInt(string));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

}


