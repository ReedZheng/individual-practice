package practicecourt.offer;

import practicecourt.offer.assistant.TreeLinkNode;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Off060 {
    public TreeLinkNode getNext(TreeLinkNode pNode) throws Exception {
        if (pNode == null) {
            return null;
        }

        while (pNode != null) {
            pNode = pNode.next;
        }

        LinkedBlockingQueue<TreeLinkNode> queue = new LinkedBlockingQueue<>();
        queue.put(pNode);
        while (!queue.isEmpty()) {
            TreeLinkNode tmp = queue.poll();
            if (tmp.left != null) {
                queue.put(tmp.left);
            }
            if (tmp.right != null) {
                queue.put(tmp.right);
            }
        }
    }
}
