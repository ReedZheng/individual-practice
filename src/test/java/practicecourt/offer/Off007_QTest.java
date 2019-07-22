package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;
import practicecourt.offer.basicstruct.BinaryTreeTraversal;

public class Off007_QTest {
    int[] pre = {1, 2, 3, 4};
    int[] in = {4, 3, 2, 1};

    @Test
    public void reConstructBinaryTree() {
        TreeNode2 root = new Off007_Q().reConstructBinaryTree(pre, in);
    }
}