package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode2;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Off062Test {
    TreeNode2 node8 = new TreeNode2(7, null, null);
    TreeNode2 node7 = new TreeNode2(5, null, null);
    TreeNode2 node6 = new TreeNode2(11, null, null);
    TreeNode2 node4 = new TreeNode2(5, null, null);
    TreeNode2 node2 = new TreeNode2(6, node4, null);
    TreeNode2 node5 = new TreeNode2(9, null, null);
    TreeNode2 node3 = new TreeNode2(10, node5, node6);
    TreeNode2 node1 = new TreeNode2(8, node2, null);

    @Test
    public void print() throws Exception {
        ArrayList<ArrayList<Integer>> list = new Off062().print3(node1);

        for (ArrayList<Integer> innerList : list) {
            for (Integer i : innerList) {
                System.out.print(i + "#");
            }
            System.out.println();
        }
    }
}