package practicecourt.offer;

import java.util.ArrayList;
import java.util.List;
import practicecourt.offer.assistant.ListNode;

public class Off006 {

    public List<Integer> reverse(ListNode firstNode) {
        List<Integer> list = new ArrayList<>();
        if (firstNode == null) {
            return list;
        }
        ListNode p = firstNode;

        while (p != null) {
            list.add(0, p.val);
            p = p.next;
        }
        return list;
    }
}
