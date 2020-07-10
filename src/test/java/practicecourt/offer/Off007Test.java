package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;

public class Off007Test {

    int[] pre = {1, 2, 3, 4};
    int[] in = {4, 3, 2, 1};

    @Test
    public void reConstructBinaryTree() {
        TreeNode2 root = new Off007().reConstructBinaryTree(pre, in);
    }
}