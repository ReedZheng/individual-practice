package practicecourt.designpattern.prototypepattern;

import java.math.BigDecimal;

public interface Order {

    BigDecimal getTotalAmount();

    void setTotalAmount(BigDecimal totalAmount);

    Produce getProduce();

    void setProduce(Produce produce);

    Order cloneOrder();
}
