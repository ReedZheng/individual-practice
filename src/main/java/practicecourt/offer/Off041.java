package practicecourt.offer;

import java.util.LinkedList;
import java.util.Queue;
import practicecourt.offer.assistant.TreeNode2;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 思路1：树的高度 = 左右子树的高度的最大值 + 1 思路2：层序遍历
 */
public class Off041 {

    public int treeDepth(TreeNode2 root) throws Exception {
        if (root == null) {
            return 0;
        }

        return recursive(root);
    }

    public int recursive(TreeNode2 node) {
        if (node.left == null && node.right == null) {
            return 1;
        }

        int leftTreeHeight = 0;
        if (node.left != null) {
            leftTreeHeight = recursive(node.left);
        }

        int rightTreeHeight = 0;
        if (node.right != null) {
            rightTreeHeight = recursive(node.right);
        }

        return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1 : rightTreeHeight + 1;
    }

    /**
     * from 牛客 思路是层序遍历，通过插入特殊的结点new TreeNode(Integer.MIN_VALUE)来计算层次
     * <p>
     * 经典的非递归层次遍历：利用辅助队列，先将头节点入队列，当队列不空时出队列的节点记为current， 当current左节点不空时入队列，其右节点不空时入队列，如此循环即可。
     * 求深度：构造变量cur记录当前层访问到的节点数，width记录当前层的总个数，每当访问过一层层数deep++； 此种方法同时可以求最大宽度，访问第几层的第几个节点，是一种通用方法！
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode2 root) {
        int depth = 0;
        if (root != null) {
            Queue q = new LinkedList<TreeNode2>();
            q.offer(root);
            q.offer(new TreeNode2(Integer.MIN_VALUE));
            while (!q.isEmpty()) {
                TreeNode2 tmp = (TreeNode2) q.poll();
                if (tmp.val != Integer.MIN_VALUE) {
                    if (tmp.left != null) {
                        q.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        q.offer(tmp.right);
                    }
                } else {
                    // 当遇到特殊节点时，说明当前层已经遍历完了同时下一层的所有节点已经全部入队了，在每层的最后压入一个特殊节点
                    depth++;
                    // 重点，不然会死循环
                    if (!q.isEmpty()) {
                        q.offer(new TreeNode2(Integer.MIN_VALUE));
                    }
                }
            }
        }
        return depth;
    }

}
