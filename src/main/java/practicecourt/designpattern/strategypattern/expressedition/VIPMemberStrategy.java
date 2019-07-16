package practicecourt.designpattern.strategypattern.expressedition;

import java.math.BigDecimal;

public class VIPMemberStrategy implements Strategy {

    @Override
    public void discount(BigDecimal originPrice) {
        System.out.println("VIP 用户 享有8折优惠，折后价为:"
            + originPrice.multiply(new BigDecimal(0.8).setScale(2, BigDecimal.ROUND_DOWN)));
    }
}
