package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.TreeLinkNode;

public class Off060Test {

    TreeLinkNode node1 = new TreeLinkNode(1);
    TreeLinkNode node2 = new TreeLinkNode(2);
    TreeLinkNode node3 = new TreeLinkNode(3);
    TreeLinkNode node4 = new TreeLinkNode(4);
    TreeLinkNode node5 = new TreeLinkNode(5);
    TreeLinkNode node6 = new TreeLinkNode(6);
    TreeLinkNode node7 = new TreeLinkNode(7);

    TreeLinkNode node11 = new TreeLinkNode(11);
    TreeLinkNode node12 = new TreeLinkNode(12);
    TreeLinkNode node13 = new TreeLinkNode(13);
    TreeLinkNode node14 = new TreeLinkNode(14);
    TreeLinkNode node15 = new TreeLinkNode(15);
    TreeLinkNode node16 = new TreeLinkNode(16);
    TreeLinkNode node17 = new TreeLinkNode(17);

    @Test
    public void getNext() throws Exception {
        node11.next = null;
        node11.left = node12;
        node11.right = node14;
        node12.next = node11;
        node14.next = node11;

        node12.left = null;
        node12.right = node13;
        node13.next = node12;

        node13.left = null;
        node13.right = node17;
        node17.next = node13;
        node17.left = node17.right = null;

        node14.left = null;
        node14.right = node15;
        node15.next = node14;
        node15.left = node16;
        node15.right = null;
        node16.next = node15;
        node16.left = node16.right = null;

        System.out.println(new Off060().getNext(node11));
        System.out.println(new Off060().getNext(node12));
        System.out.println(new Off060().getNext(node13));
        System.out.println(new Off060().getNext(node14));
        System.out.println(new Off060().getNext(node15));
        System.out.println(new Off060().getNext(node16));
        System.out.println(new Off060().getNext(node17));
        System.out.println("-------");
        System.out.println(new Off060().getNext2(node11));
        System.out.println(new Off060().getNext2(node12));
        System.out.println(new Off060().getNext2(node13));
        System.out.println(new Off060().getNext2(node14));
        System.out.println(new Off060().getNext2(node15));
        System.out.println(new Off060().getNext2(node16));
        System.out.println(new Off060().getNext2(node17));
    }
}