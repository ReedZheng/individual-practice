package practicecourt.offer.assistant;

import lombok.Data;

/**
 *
 */
@Data
public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }
}
