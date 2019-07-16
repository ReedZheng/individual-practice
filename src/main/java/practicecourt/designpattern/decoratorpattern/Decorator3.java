package practicecourt.designpattern.decoratorpattern;

/**
 * @Description:
 * @Date: 2018/11/26
 */
public class Decorator3 extends Decorator {

    public Decorator3(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        System.out.println("已为奶茶加入椰丝！");
    }
}
