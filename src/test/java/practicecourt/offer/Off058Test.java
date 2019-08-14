package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.ListNode;

import static org.junit.Assert.*;

public class Off058Test {

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);

    @Test
    public void entryNodeOfLoop() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        System.out.println(new Off058().entryNodeOfLoop(node1));

    }
}