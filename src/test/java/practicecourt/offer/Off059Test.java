package practicecourt.offer;

import org.junit.Test;
import practicecourt.offer.assistant.ListNode;

import java.util.HashMap;

public class Off059Test {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(1);
    ListNode node3 = new ListNode(2);
    ListNode node4 = new ListNode(3);
    ListNode node5 = new ListNode(3);
    ListNode node6 = new ListNode(4);
    ListNode node7 = new ListNode(5);
    ListNode node8 = new ListNode(5);

    @Test
    public void deleteDuplication() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;

        ListNode head = new Off059().deleteDuplication3(node1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }


    }
}