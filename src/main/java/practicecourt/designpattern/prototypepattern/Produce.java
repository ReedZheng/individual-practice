package practicecourt.designpattern.prototypepattern;

import java.math.BigDecimal;

public class Produce implements Cloneable {

    private String name;

    private BigDecimal price;

    private String desc;

    public Produce(String name, BigDecimal price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "[名称 - " + name + "， 描述 - " + desc + "，单价 - " + price + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
