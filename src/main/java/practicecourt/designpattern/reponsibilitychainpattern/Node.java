package practicecourt.designpattern.reponsibilitychainpattern;

public abstract class Node {

    protected Node next;

    public Node(Node next) {
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public abstract void handle(Integer amount);

}
