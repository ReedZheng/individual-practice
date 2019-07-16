package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo2;

public class OrderOperateImpl implements OrderOperate {

    private String orderName;
    private String orderDesc;
    private Integer goodCount;

    @Override
    public void getOrderName() {
        System.out.println("这是订单名称");
    }

    @Override
    public void getOrderDesc() {
        System.out.println("这是订单描述");
    }

    @Override
    public void getGoodCount() {
        System.out.println("这是商品数量");
    }

    @Override
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    @Override
    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }
}
