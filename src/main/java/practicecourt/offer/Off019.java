package practicecourt.offer;

import practicecourt.offer.assistant.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Off019 {

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(0);
        ListNode header = merged;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                merged.next = list2;
                list2 = list2.next;
            } else {
                merged.next = list1;
                list1 = list1.next;
            }
            merged = merged.next;
        }

        if (list1 != null) {
            merged.next = list1;
        }
        if (list2 != null) {
            merged.next = list2;
        }

        return header.next;
    }
}
