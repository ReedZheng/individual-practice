package practicecourt.offer.assistant;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 */
@Data
@ToString(exclude="next")
@EqualsAndHashCode(exclude="next")
public class ListNode {

    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }
}
