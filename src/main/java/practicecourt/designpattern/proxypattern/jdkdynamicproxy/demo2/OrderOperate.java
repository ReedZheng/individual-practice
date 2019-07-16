package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo2;

public interface OrderOperate {

    void getOrderName();

    void getOrderDesc();

    void getGoodCount();

    void setOrderName(String orderName);

    void setOrderDesc(String orderDesc);

    void setGoodCount(Integer goodCount);
}
