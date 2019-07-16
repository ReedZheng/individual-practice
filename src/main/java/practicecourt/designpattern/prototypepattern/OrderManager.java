package practicecourt.designpattern.prototypepattern;

import java.math.BigDecimal;

public class OrderManager {

    public void operateOrder(Order order) {
        BigDecimal compareValue = new BigDecimal("1000");
        int index = 1;

        while (order.getTotalAmount().compareTo(compareValue) > 0) {
            // 复制出一个新的订单而不需要确定是哪种订单
            Order newOrder = order.cloneOrder();
            newOrder.setTotalAmount(compareValue);
            newOrder.getProduce().setName("子订单" + String.valueOf(index));
            System.out.println("拆分：" + newOrder);
            order.setTotalAmount(order.getTotalAmount().subtract(compareValue));
            index++;
        }
        System.out.println("最后：" + order);
    }
}
