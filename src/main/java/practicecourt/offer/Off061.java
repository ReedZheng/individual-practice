package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode2;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。 自己实现并改进了！！
 */
public class Off061 {

    boolean isSymmetrical(TreeNode2 pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isMirror(pRoot.left, pRoot.right);
    }

    private boolean isMirror(TreeNode2 n1, TreeNode2 n2) {
        // 两边都无
        boolean isnull = (n1 == null) && (n2 == null);
        if (isnull) {
            return true;
        }

        // 一边有一边无
        boolean dissymmetry = (n1 == null) || (n2 == null);
        if (dissymmetry) {
            return false;
        }

        // 往下走是两边都有的情况
        if (n1.val != n2.val) {
            return false;
        }

        // 比较下层
        boolean result = isMirror(n1.left, n2.right);
        result &= isMirror(n1.right, n2.left);

        return result;

    }

}



