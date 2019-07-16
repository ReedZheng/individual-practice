package practicecourt.designpattern.builderpattern.patternwithdirector;

public class Test2 {

    public static void main(String[] args) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        ComputerAssemblerA computerAssemblerA = new ComputerAssemblerA(concreteBuilder);
        System.out.println(computerAssemblerA.assemble());
    }
}
