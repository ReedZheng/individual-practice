package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    private OrderOperate orderOperate = null;

    public ProxyFactory(OrderOperate orderOperate) {
        this.orderOperate = orderOperate;
    }

    public OrderOperate getProxy() {
        Class<? extends OrderOperate> aClass = orderOperate.getClass();
        OrderOperate proxy =
            (OrderOperate) Proxy
                .newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("操作前..");
        method.invoke(orderOperate, args);
        System.out.println("操作后..");
        return null;
    }
}
