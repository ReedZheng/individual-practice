package practicecourt.designpattern.strategypattern.expressedition;

import java.math.BigDecimal;

/**
 * http://www.jasongj.com/design_pattern/strategy/
 */
public class Text {

    public static void main(String[] args) {
        Strategy strategy = new VIPMemberStrategy();
        Context context = new Context(strategy);
        context.settleAccount(new BigDecimal(100));

        strategy = new RegularMemberStrategy();
        context = new Context(strategy);
        context.settleAccount(new BigDecimal(100));
    }
}
