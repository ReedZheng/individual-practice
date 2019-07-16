package practicecourt.designpattern.prototypepattern;

import java.math.BigDecimal;

public interface Order {

    void setTotalAmount(BigDecimal totalAmount);

    BigDecimal getTotalAmount();

    Produce getProduce();

    void setProduce(Produce produce);

    Order cloneOrder();
}
