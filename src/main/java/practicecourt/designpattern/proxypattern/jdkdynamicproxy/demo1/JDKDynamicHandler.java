package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicHandler implements InvocationHandler {

    private Consumer consumer = null;

    public JDKDynamicHandler(Consumer consumer) {
        this.consumer = consumer;
    }

    public Consumer getConsumerProxy() {
        Class<? extends Consumer> cls = consumer.getClass();
        // 这里会创建一个代理类，该类继承了Proxy并实现了 和被代理类一样 的接口（这里是Consumer接口）
        Consumer proxyConsumer = (Consumer) Proxy
            .newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);

        return proxyConsumer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("已收到代购申请，请稍候。");
        System.out.println("代购员xxx前往xxx购买。");
        method.invoke(consumer, args);
        System.out.println("结账。");
        System.out.println("购买完毕。");
        return null;
    }
}

