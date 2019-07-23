package practicecourt.offer;

import practicecourt.offer.assistant.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
// public class ListNode {
//     int val;
//     ListNode next = null;
//
//     ListNode(int val) {
//         this.val = val;
//     }
// }
public class Off018 {
    public ListNode reverseList(ListNode head) {
        ListNode end, tmp;

        if (head == null) {
            return null;
        }

        tmp = head.next;
        head.next = null;
        while ((end = tmp) != null) {
            tmp = end.next;
            end.next = head;
            head = end;
        }

        return head;
    }

    // from 牛客
    public ListNode otherMethod(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
