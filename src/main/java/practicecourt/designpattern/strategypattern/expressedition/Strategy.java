package practicecourt.designpattern.strategypattern.expressedition;

import java.math.BigDecimal;

public interface Strategy {

    void discount(BigDecimal originPrice);
}
