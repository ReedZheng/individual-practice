package practicecourt.designpattern.decoratorpattern;

/**
 * @Description:
 * @Date: 2018/11/26
 */
public class Test {

    public static void main(String[] args) {
        Decorator3 decorator = new Decorator3(new Decorator2(new Decorator1(new ConcreteComponent())));
        decorator.operate();
    }
}
