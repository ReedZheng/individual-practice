package practicecourt.offer;

import java.util.HashMap;
import practicecourt.offer.assistant.RandomListNode;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点， 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * <p>
 * 参考牛客： 方法1：map关联，首先遍历一遍原链表，创建新链表（赋值label和next），用map关联对应结点；再遍历一遍， 更新新链表的random指针。
 * 方法2：在旧链表中创建新链接，此时不处理新链表的兄弟节点；根据旧链表的兄弟节点，初始化新链表的兄弟节点； 从旧链表中拆分得到新链表。
 */
public class Off028 {

    public RandomListNode customClone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode tmp = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        while (tmp != null) {
            map.put(tmp, new RandomListNode(tmp.label));
            tmp = tmp.next;
        }

        tmp = pHead;
        while (tmp != null) {
            map.get(tmp).next = map.get(tmp.next);
            tmp = tmp.next;
        }

        tmp = pHead;
        while (tmp != null) {
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }

        return map.get(pHead);
    }
}


