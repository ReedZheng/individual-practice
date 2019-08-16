package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode2;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 总觉得可以改进一下。。看着觉得好辣鸡
 */
public class Off062 {
    public ArrayList<ArrayList<Integer>> print(TreeNode2 pRoot) throws Exception {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }

        Stack<TreeNode2> stack = new Stack<>();
        stack.push(pRoot);
        LinkedBlockingQueue<TreeNode2> queue = new LinkedBlockingQueue<>();

        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(pRoot.val);
        list.add(innerList);
        innerList = new ArrayList<>();

        int count = 0;

        while (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                TreeNode2 node = stack.pop();
                TreeNode2 right = node.right;
                TreeNode2 left = node.left;

                if ((count & 1) == 0) {
                    if (right != null) {
                        queue.put(right);
                    }
                    if (left != null) {
                        queue.put(left);
                    }
                } else {
                    if (left != null) {
                        queue.put(left);
                    }
                    if (right != null) {
                        queue.put(right);
                    }
                }
            }

            if (queue.size() > 0) {
                for (TreeNode2 node : queue) {
                    innerList.add(node.val);
                    stack.push(node);
                }
                list.add(innerList);
                innerList = new ArrayList<>();
                queue.clear();
            }

            count++;
        }

        return list;
    }

    /**
     * from 牛客，用两个 ArrayList 实现，优秀
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print2(TreeNode2 pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }

        ArrayList<TreeNode2> queue = new ArrayList<>();
        ArrayList<Integer> temp;
        queue.add(pRoot);

        int line = 1;

        while (queue.size() > 0) {
            int num = queue.size();
            temp = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                TreeNode2 root = queue.remove(0);
                // 奇数行
                if (line % 2 == 1) {
                    temp.add(root.val);
                } else {
                    temp.add(0, root.val);
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }

            line++;
            list.add(temp);
        }

        return list;
    }

}
