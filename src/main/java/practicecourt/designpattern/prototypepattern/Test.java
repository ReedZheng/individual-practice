package practicecourt.designpattern.prototypepattern;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
        BigDecimal totalAmount = new BigDecimal("3998");
        Produce produce = new Produce("苹果", new BigDecimal("9"), "niceeee");
        Order order = new EnterpriseOrder(totalAmount, produce);

        OrderManager orderManager = new OrderManager();
        orderManager.operateOrder(order);
    }
}
