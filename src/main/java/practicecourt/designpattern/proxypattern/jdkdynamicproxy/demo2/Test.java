package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo2;

public class Test {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new OrderOperateImpl());
        OrderOperate proxy = proxyFactory.getProxy();
        proxy.getGoodCount();
    }
}
