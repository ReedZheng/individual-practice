package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 想的时候不要进入递归，想好第一层就可以，往下每一次都按第一层的方式进行
 */
public class Off020 {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.getVal().equals(root2.getVal())) {
                result = inSubtree(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.getLeft(), root2);
            }
            if (!result) {
                result = hasSubtree(root1.getRight(), root2);
            }
        }
        return result;
    }

    public boolean inSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.getVal().equals(root2.getVal())) {
            return inSubtree(root1.getLeft(), root2.getLeft()) && inSubtree(root1.getRight(), root2.getRight());
        } else {
            return false;
        }
    }
}

