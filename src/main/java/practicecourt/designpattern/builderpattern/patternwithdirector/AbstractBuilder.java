package practicecourt.designpattern.builderpattern.patternwithdirector;

public abstract class AbstractBuilder {

    protected Computer computer = Computer.getInstance();

    public abstract AbstractBuilder buildPartA();

    public abstract AbstractBuilder buildPartB();

    public abstract AbstractBuilder buildPartC();

    public Computer build() {
        return computer;
    }
}
