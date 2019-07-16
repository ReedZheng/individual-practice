package practicecourt.designpattern.builderpattern.patternwithdirector;

public class ComputerAssemblerA {

    private ConcreteBuilder concreteBuilder;

    public ComputerAssemblerA(ConcreteBuilder concreteBuilder) {
        this.concreteBuilder = concreteBuilder;
    }

    public Computer assemble() {
        Computer computer = concreteBuilder.buildPartA().buildPartB().buildPartC().build();
        return computer;
    }

}
