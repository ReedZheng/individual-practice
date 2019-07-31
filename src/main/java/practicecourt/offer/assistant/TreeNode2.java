package practicecourt.offer.assistant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"left", "right"})
public class TreeNode2 {

    public int val;
    public TreeNode2 left;
    public TreeNode2 right;

    public TreeNode2(int val) {
        this.val = val;
    }
}
