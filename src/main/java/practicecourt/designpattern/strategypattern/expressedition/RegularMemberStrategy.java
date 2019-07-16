package practicecourt.designpattern.strategypattern.expressedition;

import java.math.BigDecimal;

public class RegularMemberStrategy implements Strategy {

    @Override
    public void discount(BigDecimal originPrice) {
        System.out.println("普通会员没有优惠。价格为：" + originPrice);
    }
}
