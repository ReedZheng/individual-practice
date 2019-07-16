package practicecourt.designpattern.decoratorpattern;

/**
 * @Description:
 * @Date: 2018/11/26
 */
public class Decorator1 extends Decorator {

    public Decorator1(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("已为奶茶加热！");
    }
}
