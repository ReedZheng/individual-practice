package practicecourt.offer;

import practicecourt.offer.assistant.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
// public class ListNode {
//     int val;
//     ListNode next = null;
//
//     ListNode(int val) {
//         this.val = val;
//     }
// }
public class Off019 {
    public ListNode merge(ListNode list1, ListNode list2) {
        int list1count = 0, list2count = 0;

        while (list1 != null) {
            list1count++;
            list1 = list1.next;
        }
        while (list2 != null) {
            list2count++;
            list2 = list2.next;
        }

        ListNode merged = list1count > list2count ? list1 : list2;
        ListNode list = list1count < list2count ? list1 : list2;

        while (list != null) {

        }

        return null;

    }
}
