package practicecourt.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Off027 {
    TreeNode node2 = new TreeNode(12, null, null);
    TreeNode node3 = new TreeNode(4, null, null);
    TreeNode node4 = new TreeNode(7, null, null);
    TreeNode node1 = new TreeNode(5, node3, node4);
    TreeNode node0 = new TreeNode(10, node1, node2);

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> uselessList = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                subList.add(root.val);
                sum += root.val;
                stack.push(root);
                root = root.left;
            }
            if (sum != target) {
                TreeNode tmp = stack.peek();
                if (tmp.right != null && !uselessList.contains(tmp.right)) {
                    root = tmp.right;
                    stack.push(root);
                    subList.add(root.val);
                } else {
                    TreeNode pop = stack.pop();
                    sum -= pop.val;
                    uselessList.add(pop);
                    subList.remove(new Integer(pop.val));
                }
            } else {
                list.add(subList);
            }
        }

        return list;
    }
}



