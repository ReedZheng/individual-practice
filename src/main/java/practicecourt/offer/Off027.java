package practicecourt.offer;

import java.util.ArrayList;
import java.util.Stack;
import practicecourt.offer.assistant.TreeNode2;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。 (注意:
 * 在返回值的list中，数组长度大的数组靠前) 做法类似二叉树的后序遍历
 */

public class Off027 {

    TreeNode2 node5 = new TreeNode2(9, null, null);
    TreeNode2 node3 = new TreeNode2(2, null, null);
    TreeNode2 node4 = new TreeNode2(7, null, node5);
    TreeNode2 node2 = new TreeNode2(12, null, null);
    TreeNode2 node1 = new TreeNode2(5, node3, node4);
    TreeNode2 node0 = new TreeNode2(10, node1, node2);
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    // from 牛客
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode2 root, int target) {
        int sum = 0;
        Stack<TreeNode2> stack = new Stack<>();
        ArrayList<Integer> subList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // 保存拥有右节点的节点，在回溯时就不需要再考虑其右节点。
        ArrayList<TreeNode2> visitedNode = new ArrayList<>();

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

            TreeNode2 tmp = stack.peek();

            if (tmp.left == null && tmp.right == null) {
                if (sum == target) {
                    list.add((ArrayList<Integer>) subList.clone());
                }
                TreeNode2 pop = stack.pop();
                sum -= pop.val;
                subList.remove(new Integer(pop.val));

            } else {
                if (tmp.right != null && !visitedNode.contains(tmp)) {
                    root = tmp.right;
                    visitedNode.add(tmp);
                } else {
                    TreeNode2 pop = stack.pop();
                    sum -= pop.val;
                    subList.remove(new Integer(pop.val));
                }
            }
        }

        return list;
    }

    public ArrayList<ArrayList<Integer>> findPath2(TreeNode2 root, int target) {
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



