package practicecourt.designpattern.prototypepattern;

import java.math.BigDecimal;

public class EnterpriseOrder implements Order, Cloneable {

    private BigDecimal totalAmount;
    private Produce produce;

    public EnterpriseOrder(BigDecimal totalAmount, Produce produce) {
        this.totalAmount = totalAmount;
        this.produce = produce;
    }

    @Override
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    @Override
    public Produce getProduce() {
        return this.produce;
    }

    @Override
    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    @Override
    public Order cloneOrder() {
        try {
//            浅复制
//            return (EnterpriseOrder) super.clone();
            // 深复制
            EnterpriseOrder newOne = (EnterpriseOrder) super.clone();
            newOne.setProduce((Produce) produce.clone());
            return newOne;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "个人订单，购买的商品： " + produce + ", totalAmount = " + this.totalAmount;
    }
}
