package practicecourt.offer.basicstruct;

import practicecourt.offer.assistant.ExceptionHandler;
import practicecourt.offer.assistant.TreeNode;

import java.util.Optional;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树前中后序遍历
 */
public class BinaryTreeTraversal {

    /**
     * 根据前序遍历访问的顺序，优先访问根结点，然后再分别访问左孩子和右孩子。 即对于任一结点，其可看做是根结点， 因此可以直接访问，访问完之后，若其左孩子不为空，按相同规则访问它的左子树；
     * 当访问其左子树时，再访问它的右子树。 因此其处理过程如下： 对于任一结点P： 1)访问结点P，并将结点P入栈； 2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，循环至1)；
     * 若不为空，则将P的左孩子置为当前的结点P； 3)直到P为NULL并且栈为空，则遍历结束。
     */
    public void preTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (current != null) {
                System.out.print(current.getVal() + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                stack.push(current);
                current = current.getLeft();
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.getRight();
            }
        }
    }

    public void midTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            if (!stack.empty()) {
                current = stack.pop();
                System.out.print(current.getVal() + " ");
                current = current.getRight();
            }
        }
    }

    public void postTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // 标记已经出栈的节点，避免回溯的时候重新入栈
        TreeNode lastVisit = null;

        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.peek();
            if (current.getRight() == null || current.getRight() == lastVisit) {
                TreeNode popNode = stack.pop();
                System.out.print(popNode.getVal() + " ");
                lastVisit = current;
                current = null;
            } else {
                current = current.getRight();
            }
        }
    }

    /**
     * 层序遍历
     */
    public void sequenceTraversal(TreeNode root) throws InterruptedException {
        LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>(16);
        queue.put(root);

        while (!queue.isEmpty()) {
            TreeNode takeNode = queue.take();
            System.out.print(takeNode.getVal() + " ");
            // 自定义 Consumer 函数接口
            Optional.ofNullable(takeNode.getLeft()).ifPresent(ExceptionHandler.toConsumer(queue::put));
            Optional.ofNullable(takeNode.getRight()).ifPresent(ExceptionHandler.toConsumer(queue::put));
        }
    }


    // 递归实现

    public void preTraversalUseRecursion(TreeNode root) {
        if (root != null) {
            System.out.print(root.getVal() + " ");
            preTraversalUseRecursion(root.getLeft());
            preTraversalUseRecursion(root.getRight());
        }
    }

}



