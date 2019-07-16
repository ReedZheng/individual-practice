package practicecourt.designpattern.reponsibilitychainpattern;

public class ConcreteNode2 extends Node {

    public ConcreteNode2(Node node) {
        super(node);
    }

    @Override
    public void handle(Integer amount) {
        if (amount < 200) {
            System.out.println("2节点进行处理，处理完成。");
        } else {
            if (next != null) {
                System.out.println("2节点无权处理，已转上级");
                next.handle(amount);
            }
        }
    }
}
