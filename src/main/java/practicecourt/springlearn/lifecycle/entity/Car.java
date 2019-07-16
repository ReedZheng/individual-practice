package practicecourt.springlearn.lifecycle.entity;

/**
 *
 */
public class Car {

    private String carNo;

    public Car() {
        System.out.println("car..construct..");
    }

    public void init() {
        System.out.println("car..init..");
    }

    public void destroy() {
        System.out.println("car..destroy..");
    }
}
