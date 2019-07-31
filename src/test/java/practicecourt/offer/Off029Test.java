package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;

public class Off029Test {

    TreeNode2 node8 = new TreeNode2(29, null, null);
    TreeNode2 node7 = new TreeNode2(28, null, node8);
    TreeNode2 node6 = new TreeNode2(30, node7, null);
    TreeNode2 node4 = new TreeNode2(7, null, null);
    TreeNode2 node2 = new TreeNode2(9, node4, null);
    TreeNode2 node5 = new TreeNode2(23, null, null);
    TreeNode2 node3 = new TreeNode2(24, node5, node6);
    TreeNode2 node1 = new TreeNode2(20, node2, node3);

    @Test
    public void convert() {
        TreeNode2 head = new Off029().convert(node1);
        TreeNode2 tail = null;

        while (head != null) {
            System.out.print(head.val + " ");
            if (head.right == null) {
                tail = head;
            }
            head = head.right;
        }
        System.out.println();

        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.left;
        }
    }
}