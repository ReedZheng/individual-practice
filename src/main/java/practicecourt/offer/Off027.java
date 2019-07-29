package practicecourt.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 做法类似二叉树的后序遍历
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
    TreeNode node5 = new TreeNode(9, null, null);
    TreeNode node3 = new TreeNode(2, null, null);
    TreeNode node4 = new TreeNode(7, null, node5);
    TreeNode node2 = new TreeNode(12, null, null);
    TreeNode node1 = new TreeNode(5, node3, node4);
    TreeNode node0 = new TreeNode(10, node1, node2);

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // 保存拥有右节点的节点，在回溯时就不需要再考虑其右节点。
        ArrayList<TreeNode> visitedNode = new ArrayList<>();

        if (root == null) {
            return list;
        }

        while (root != null || !stack.empty()) {
            while (root != null) {
                subList.add(root.val);
                sum += root.val;
                stack.push(root);
                root = root.left;
            }

            TreeNode tmp = stack.peek();

            if (tmp.left == null && tmp.right == null) {
                if (sum == target) {
                    list.add((ArrayList<Integer>)subList.clone());
                }
                TreeNode pop = stack.pop();
                sum -= pop.val;
                subList.remove(new Integer(pop.val));

            } else {
                if (tmp.right != null && !visitedNode.contains(tmp)) {
                    root = tmp.right;
                    visitedNode.add(tmp);
                } else {
                    TreeNode pop = stack.pop();
                    sum -= pop.val;
                    subList.remove(new Integer(pop.val));
                }
            }
        }

        return list;
    }

    // from 牛客

    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath2(TreeNode root, int target) {
        if (root == null) {
            return resultList;
        }
        list.add(root.val);

        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        }

        if (root.left != null) {
            findPath2(root.left, target);
        }
        if (root.right != null) {
            findPath2(root.right, target);
        }

        //这一步的作用：每返回上一层一次就要回退一个节点
        list.remove(list.size() - 1);

        return resultList;

    }

}



