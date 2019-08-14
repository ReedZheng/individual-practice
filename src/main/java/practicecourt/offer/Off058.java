package practicecourt.offer;

import practicecourt.offer.assistant.ListNode;

import java.util.HashMap;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Off058 {
    public ListNode entryNodeOfLoop(ListNode pHead) {

        HashMap<ListNode, Integer> map = new HashMap<>();
        while (pHead != null) {
            if (map.containsKey(pHead)) {
                return pHead;
            }
            map.put(pHead, 1);
            pHead = pHead.next;
        }

        return null;
    }

    /**
     * 左神讲的
     * 先说个定理：两个指针一个fast、一个slow同时从一个链表的头部出发
     * fast一次走2步，slow一次走一步，如果该链表有环，两个指针必然在环内相遇
     * 此时只需要把其中的一个指针重新指向链表头部，另一个不变（还在环内），
     * 这次两个指针一次走一步，相遇的地方就是入口节点。
     * 这个定理可以自己去网上看看证明。
     */
    public ListNode entryNodeOfLoop2(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
