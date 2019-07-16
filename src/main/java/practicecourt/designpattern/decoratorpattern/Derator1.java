package practicecourt.designpattern.decoratorpattern;

public class Derator1 extends Derator {

    public Derator1(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("Derator1 为操作添加新功能");
    }

}
