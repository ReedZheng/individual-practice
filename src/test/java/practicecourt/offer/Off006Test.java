package practicecourt.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import practicecourt.offer.Off006;
import practicecourt.offer.assistant.ListNode;

import java.util.List;

@Slf4j
public class Off006Test {

    @Test
    public void reverse() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(102);
        ListNode node3 = new ListNode(152);
        ListNode node4 = new ListNode(412);
        ListNode node5 = new ListNode(12);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        List<Integer> reverse = new Off006().reverse(node1);
        log.info("链表倒排结果：{}", reverse);
    }
}