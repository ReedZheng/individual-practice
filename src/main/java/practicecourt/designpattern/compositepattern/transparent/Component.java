package practicecourt.designpattern.compositepattern.transparent;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    protected String name = "";

    public Component(String name) {
        this.name = name;
    }

    protected List<Component> leaves = new ArrayList<>();

    public abstract void add(Leaf leaf);

    public abstract void remove(Leaf leaf);

    public abstract void operate(int depth);

    public List<Component> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Component> leaves) {
        this.leaves = leaves;
    }

    @Override
    public String toString() {
        return name;
    }
}
