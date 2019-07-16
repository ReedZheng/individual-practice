package practicecourt.designpattern.compositepattern.transparent;

public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Leaf leaf) {
    }

    @Override
    public void remove(Leaf leaf) {
    }

    @Override
    public void operate(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(name);
    }
}
