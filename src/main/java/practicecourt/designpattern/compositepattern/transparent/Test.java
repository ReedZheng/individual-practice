package practicecourt.designpattern.compositepattern.transparent;

import java.util.List;

/**
 * https://blog.csdn.net/u013256816/article/details/51009417
 */
public class Test {

    public static void main(String[] args) {
        Composite root = new Composite("Root");

        Leaf leaf2 = new Leaf("Leaf");

        Leaf leaf3 = new Leaf("Leaf");

        Leaf leaf4 = new Leaf("Leaf");

        Composite composite5 = new Composite("Composite");
        Leaf leaf51 = new Leaf("Leaf");
        Leaf leaf52 = new Leaf("Leaf");
        List<Component> leaves = composite5.getLeaves();
        leaves.add(leaf51);
        leaves.add(leaf52);

        List<Component> rootLeaves = root.getLeaves();
        rootLeaves.add(leaf2);
        rootLeaves.add(leaf3);
        rootLeaves.add(leaf4);
        rootLeaves.add(composite5);

        root.operate(0);

    }
}
