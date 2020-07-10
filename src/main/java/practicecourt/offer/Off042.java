package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode2;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。 定义：平衡二叉查找树，简称平衡二叉树，它具有如下几个性质： 1. 可以是空树。 2.
 * 假如不是空树，任何一个节点的左子树与右子树都是平衡二叉树，并且高度之差的绝对值不超过 1。
 * <p>
 * 对平衡二叉树的定义有误解。。 感觉自己的做法是有问题的。。。
 */
public class Off042 {
    /*public boolean isBalancedSolution(TreeNode2 root) {
        if (root == null) {
            return true;
        }

        ArrayList<Integer> allRouteLen = new ArrayList<>();
        int len = 0;

        recordRouteLen(root, allRouteLen, len);

        // 当二叉树退化为链表时单独处理
        if (allRouteLen.size() == 1 && allRouteLen.get(0) > 1) {
            return false;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (Integer i : allRouteLen) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }

        return max - min <= 1;
    }

    private void recordRouteLen(TreeNode2 node, ArrayList<Integer> list, int len) {
        if (node.left == null && node.right == null) {
            list.add(len);
            return;
        }
        if (node.left != null) {
            if (node.right == null) {
                list.add(len);
            }
            recordRouteLen(node.left, list, len + 1);
        }
        if (node.right != null) {
            recordRouteLen(node.right, list, len + 1);
        }
    }*/

    /**
     * 后序遍历做法，from 牛客 后序遍历时，遍历到一个节点，其左右子树已经遍历，依次自底向上判断，每个节点只需要遍历一次
     */
    private boolean isBalanced = true;

    public boolean isBalancedSolution2(TreeNode2 root) {
        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode2 root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return right > left ? right + 1 : left + 1;

    }
}


