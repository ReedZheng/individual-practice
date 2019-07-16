package practicecourt.designpattern.strategypattern.expressedition;

import java.math.BigDecimal;

public class Context {

    private Strategy strategy = null;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 结清账款
    public void settleAccount(BigDecimal price) {
        strategy.discount(price);
    }
}
