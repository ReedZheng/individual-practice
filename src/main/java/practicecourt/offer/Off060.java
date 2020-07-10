package practicecourt.offer;

import practicecourt.offer.assistant.TreeLinkNode;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Off060 {

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeLinkNode father = pNode.next;
        TreeLinkNode tmp;

        if ((tmp = pNode.right) != null) {
            // 如果右节点的左节点也不为空，按照中序遍历的顺序，应输出右节点的左节点
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            return tmp;

        } else {
            // 如果父节点为空，说明当前节点为整棵树的根节点，并且此时的右节点为空，因此直接返回null
            // 如果父节点不为空，说明当前节点在某个子树中，需要判断当前节点在其子树的左边还是右边，根据判断的结果进行不同的处理
            if (father != null) {
                if (pNode == father.left) {
                    return father;
                }

                //  pNode = 3, return null |     pNode = 6, return 1
                //    1                    |            1
                //   /\                    |           / \
                //  2 3                    |          2   3
                //                                   /\
                //                                  4  5
                //                                      \
                //                                       6
                if (pNode == father.right) {
                    while (father.next != null && father == father.next.right) {
                        father = father.next;
                    }
                    return father.next;
                }
            }
        }

        return null;
    }

    /**
     * from 牛客，优秀
     *
     * @param node
     * @return
     */
    public TreeLinkNode getNext2(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        // 如果有右子树，则找右子树的最左节点
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

        // 没右子树，则找第一个 当前节点是父节点左孩子 的节点
        while (node.next != null) {
            if (node.next.left == node) {
                return node.next;
            }
            node = node.next;
        }

        // 退到了根节点仍没找到，则返回null
        return null;
    }
}
