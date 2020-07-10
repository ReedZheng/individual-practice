package practicecourt.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import practicecourt.offer.assistant.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点， 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Off059 {

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode tmp = pHead;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        HashMap<Integer, ListNode> map2 = new HashMap<>();

        while (tmp != null) {
            if (map.containsKey(tmp.val)) {
                map.put(tmp.val, 2);
            } else {
                map.put(tmp.val, 1);
            }
            map2.put(tmp.val, tmp);

            tmp = tmp.next;
        }

        pHead = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ListNode n = map2.get(entry.getKey());
                // 断掉节点后边无关的内容
                n.next = null;

                if (tmp == null) {
                    tmp = n;
                    pHead = tmp;
                    continue;
                }
                tmp = tmp.next = n;
            }
        }

        return pHead;
    }

    /**
     * from 牛客，构造头节点！！优秀
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode first = new ListNode(0);
        first.next = pHead;
        ListNode p = pHead;
        ListNode pre = first;
        while (p != null && p.next != null) {
            if (p.val.equals(p.next.val)) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                pre.next = p;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return first.next;
    }

    /**
     * from 牛客
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication3(ListNode pHead) {
        // 只有0个或1个结点，则返回
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        // 当前结点是重复结点
        if (pHead.val.equals(pHead.next.val)) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val.equals(pHead.val)) {
                // 跳过值与当前结点相同的全部结点，找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication3(pNode);
        } else {
            // 当前结点不是重复结点,保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication3(pHead.next);
            return pHead;
        }
    }
}
