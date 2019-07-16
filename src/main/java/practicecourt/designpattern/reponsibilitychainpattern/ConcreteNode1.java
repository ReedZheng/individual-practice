package practicecourt.designpattern.reponsibilitychainpattern;

public class ConcreteNode1 extends Node {

    public ConcreteNode1(Node node) {
        super(node);
    }

    @Override
    public void handle(Integer amount) {
        if (amount < 100) {
            System.out.println("1节点进行处理，处理完成。");
        } else {
            if (next != null) {
                System.out.println("1节点无权处理，已转上级");
                next.handle(amount);
            }
        }
    }
}
