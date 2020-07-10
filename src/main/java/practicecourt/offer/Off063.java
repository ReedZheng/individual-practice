package practicecourt.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import practicecourt.offer.assistant.TreeNode2;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Off063 {

    ArrayList<ArrayList<Integer>> print(TreeNode2 pRoot) throws Exception {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }

        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(pRoot.val);
        list.add(innerList);

        LinkedBlockingQueue<TreeNode2> unEmpty = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<TreeNode2> empty = new LinkedBlockingQueue<>();

        unEmpty.put(pRoot);

        while (!unEmpty.isEmpty()) {
            innerList = new ArrayList<>();

            while (!unEmpty.isEmpty()) {
                TreeNode2 node = unEmpty.poll();

                if (node.left != null) {
                    empty.put(node.left);
                }

                if (node.right != null) {
                    empty.put(node.right);
                }
            }

            while (!empty.isEmpty()) {
                TreeNode2 node = empty.poll();
                innerList.add(node.val);
                unEmpty.put(node);
            }

            if (innerList.size() > 0) {
                list.add(innerList);
            }
        }

        return list;
    }

    /**
     * from 牛客，start, end 两个变量优雅地区分每一层的数据
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> print2(TreeNode2 pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode2> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);

        // 可以获取到每一层的节点的数量
        int start = 0, end = 1;

        while (!layer.isEmpty()) {
            TreeNode2 cur = layer.remove();
            layerList.add(cur.val);
            start++;

            if (cur.left != null) {
                layer.add(cur.left);
            }
            if (cur.right != null) {
                layer.add(cur.right);
            }

            if (start == end) {
                end = layer.size();
                start = 0;
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }

        return result;
    }

    /**
     * 改进
     *
     * @param pRoot
     * @return
     * @throws Exception
     */
    ArrayList<ArrayList<Integer>> print3(TreeNode2 pRoot) throws Exception {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }

        ArrayList<Integer> innerList = new ArrayList<>();

        LinkedBlockingQueue<TreeNode2> queue = new LinkedBlockingQueue<>();
        queue.put(pRoot);
        // 可以获取到每一层的节点的数量
        int start = 0, end = 1;

        while (!queue.isEmpty()) {
            TreeNode2 node = queue.poll();
            start++;
            innerList.add(node.val);

            if (node.left != null) {
                queue.put(node.left);
            }

            if (node.right != null) {
                queue.put(node.right);
            }

            if (start == end) {
                list.add(innerList);
                start = 0;
                end = queue.size();
                innerList = new ArrayList<>();
            }
        }

        return list;
    }
}
