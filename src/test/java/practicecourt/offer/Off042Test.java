package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;

import static org.junit.Assert.*;

public class Off042Test {

    TreeNode2 node7 = new TreeNode2(88, null, null);
    TreeNode2 node6 = new TreeNode2(75, null, null);
    TreeNode2 node5 = new TreeNode2(30, null, null);
    TreeNode2 node4 = new TreeNode2(50, node5, null);
    TreeNode2 node2 = new TreeNode2(60, node4, null);
    TreeNode2 node3 = new TreeNode2(77, node6, node7);
    TreeNode2 node1 = new TreeNode2(66, node2, node3);

    @Test
    public void isBalancedSolution() {
        System.out.println(new Off042().isBalancedSolution2(node1));
    }
}