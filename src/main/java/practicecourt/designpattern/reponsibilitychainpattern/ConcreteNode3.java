package practicecourt.designpattern.reponsibilitychainpattern;

public class ConcreteNode3 extends Node {

    public ConcreteNode3(Node node) {
        super(node);
    }

    @Override
    public void handle(Integer amount) {
        System.out.println("3节点进行处理，处理完成。");
    }
}
