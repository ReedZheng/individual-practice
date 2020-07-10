package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。 自己做出来了！！！麻叶！！！
 */
public class Off021 {

    public void mirror(TreeNode root) {
        if (root != null) {
            swap(root);
        }
    }

    public void swap(TreeNode root) {
        TreeNode left = root.getLeft();
        TreeNode right = root.getRight();

        if (left != null) {
            swap(left);
        }
        if (right != null) {
            swap(right);
        }

        root.setLeft(right);
        root.setRight(left);
    }
}
