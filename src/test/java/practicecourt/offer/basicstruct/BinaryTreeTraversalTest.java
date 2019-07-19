package practicecourt.offer.basicstruct;

import org.junit.Test;
import practicecourt.offer.assistant.TreeNode;

public class BinaryTreeTraversalTest {

    TreeNode node7 = new TreeNode("7", null, null);
    TreeNode node8 = new TreeNode("8", null, null);
    TreeNode node6 = new TreeNode("6", node7, node8);
    TreeNode node4 = new TreeNode("4", null, node6);
    TreeNode node2 = new TreeNode("2", node4, null);
    TreeNode node5 = new TreeNode("5", null, null);
    TreeNode node3 = new TreeNode("3", null, node5);
    TreeNode node1 = new TreeNode("1", node2, node3);


    TreeNode tnode7 = new TreeNode("7", null, null);
    TreeNode tnode6 = new TreeNode("6", null, null);
    TreeNode tnode5 = new TreeNode("5", tnode6, tnode7);
    TreeNode tnode4 = new TreeNode("4", null, tnode5);
    TreeNode tnode3 = new TreeNode("3", null, null);
    TreeNode tnode2 = new TreeNode("2", tnode3, tnode4);
    TreeNode tnode8 = new TreeNode("8", null, null);
    TreeNode tnode1 = new TreeNode("1", tnode2, tnode8);

    @Test
    public void preTraversal() {
        new BinaryTreeTraversal().preTraversal(node1);
        System.out.println("");
        new BinaryTreeTraversal().midTraversal(node1);
        System.out.println("");
        new BinaryTreeTraversal().postTraversal(tnode1);
        System.out.println("");
    }
}