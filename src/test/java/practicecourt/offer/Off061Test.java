package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;

import static org.junit.Assert.*;

public class Off061Test {

    TreeNode2 node7 = new TreeNode2(3, null, null);
    TreeNode2 node4 = new TreeNode2(3, null, null);
    TreeNode2 node2 = new TreeNode2(2, node4, null);

    TreeNode2 node5 = new TreeNode2(3, null, null);
    TreeNode2 node6 = new TreeNode2(3, null, null);
    TreeNode2 node3 = new TreeNode2(2, null, node6);

    TreeNode2 node1 = new TreeNode2(1, node2, node3);

    @Test
    public void isSymmetrical() {
        System.out.println(new Off061().isSymmetrical(node1));
    }
}


