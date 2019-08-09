package practicecourt.offer;

import practicecourt.offer.assistant.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * <p>
 * 如果存在共同节点的话，那么从该节点，两个链表之后的元素都是相同的！！！
 */
public class Off039 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        while (pHead1 != null) {
            list.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            if (list.contains(pHead2)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }

        return null;
    }

    public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }

        return p1;
    }
}
