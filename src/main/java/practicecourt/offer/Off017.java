package practicecourt.offer;

import practicecourt.offer.assistant.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Off017 {

    public ListNode findKthToTail(ListNode head, int k) {
        int length = 0;
        ListNode tmp = head;

        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }

        if (k > length) {
            return null;
        } else {
            int len = length - k;
            for (int i = 0; i < len; i++) {
                head = head.next;
            }
            return head;
        }
    }

    // from 牛客网
    public ListNode findKthToTail2(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;

        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }

        return i < k ? null : q;
    }
}


