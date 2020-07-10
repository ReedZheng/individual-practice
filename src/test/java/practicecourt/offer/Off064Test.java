package practicecourt.offer;

import static org.junit.Assert.*;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;

public class Off064Test {

    TreeNode2 node8 = new TreeNode2(29, null, null);
    TreeNode2 node7 = new TreeNode2(28, null, node8);
    TreeNode2 node6 = new TreeNode2(30, node7, null);
    TreeNode2 node4 = new TreeNode2(7, null, null);
    TreeNode2 node5 = new TreeNode2(23, null, null);
    TreeNode2 node2 = new TreeNode2(9, node4, null);
    TreeNode2 node3 = new TreeNode2(24, node5, node6);
    TreeNode2 node1 = new TreeNode2(20, node2, node3);

    @Test
    public void serialize() {
        String serialize = new Off064().serialize3(node1);
        System.out.println(serialize);
    }

    @Test
    public void deserialize() {
        new Off064().deserialize(new Off064().serialize(node1));
    }
}