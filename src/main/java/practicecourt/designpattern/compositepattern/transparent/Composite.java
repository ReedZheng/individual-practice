package practicecourt.designpattern.compositepattern.transparent;

public class Composite extends Component {

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Leaf leaf) {
        leaves.add(leaf);
    }

    @Override
    public void remove(Leaf leaf) {
        if (leaves.indexOf(leaf) > 0) {
            remove(leaf);
        }
    }

    @Override
    public void operate(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(name);
        for (Component c : leaves) {
            c.operate(depth + 1);
        }
    }
}
