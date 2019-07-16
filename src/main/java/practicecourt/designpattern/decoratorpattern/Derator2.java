package practicecourt.designpattern.decoratorpattern;

public class Derator2 extends Derator {

    public Derator2(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("Derator2 为操作添加新功能");
    }
}
