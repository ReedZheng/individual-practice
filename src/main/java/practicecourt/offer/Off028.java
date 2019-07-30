package practicecourt.offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    RandomListNode(int label, RandomListNode next, RandomListNode random) {
        this.label = label;
        this.next = next;
        this.random = random;
    }
}

public class Off028 {
    public RandomListNode customClone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode head = pHead;
        RandomListNode newHeader = null;
        RandomListNode pre = new RandomListNode(-1);

        while (head != null) {
            newHeader = new RandomListNode(head.label);
            pre = pre.next = newHeader;
            head = head.next;
        }

        return newHeader;
    }
}


