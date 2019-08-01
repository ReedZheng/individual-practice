package practicecourt.offer;

import practicecourt.offer.assistant.TreeNode2;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 在二叉树的中序遍历基础上，对从栈中弹出的序列进行指针操作，实现双向链表。
 * 牛客上更好的做法：Morris Traversal，将二叉树重构为所有结点只有右子树的一条链
 */
public class Off029 {
    public TreeNode2 convert(TreeNode2 pRootOfTree) {
        TreeNode2 pre = null, current = null, head = null;
        Stack<TreeNode2> stack = new Stack<>();

        if (pRootOfTree == null) {
            return null;
        }

        while (pRootOfTree != null || !stack.empty()) {
            while (pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }

            if (!stack.empty()) {
                pre = current;
                current = stack.pop();

                if (head == null) {
                    head = current;
                } else {
                    pre.right = current;
                    current.left = pre;
                }

                pRootOfTree = current.right;
            }
        }

        if (head != null) {
            head.left = null;
            current.right = null;
        }

        return head;
    }

    /**
     * from 牛客，画图
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode2 convert2(TreeNode2 pRootOfTree) {
        TreeNode2 p = pRootOfTree, pre = null, res = null;
        while (p != null) {
            while (p.left != null) {
                TreeNode2 q = p.left;
                while (q.right != null) {
                    q = q.right;
                }
                q.right = p;
                TreeNode2 tmp = p.left;
                p.left = null;
                p = tmp;
            }
            p.left = pre;
            if (pre == null) {
                res = p;
            } else {
                pre.right = p;
            }
            pre = p;
            p = p.right;
        }
        return res;
    }

    /**
     * Mirror Traversal，参考：https://oychao.github.io/2016/05/13/algorithm/01_morris/
     *
     * @param head
     */
    public void morris(TreeNode2 head) {
        if (head == null) {
            return;
        }

        TreeNode2 current, pre;
        current = head;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }
}
