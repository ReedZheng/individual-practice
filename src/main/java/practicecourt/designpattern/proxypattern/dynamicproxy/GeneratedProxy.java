package practicecourt.designpattern.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GeneratedProxy implements InvocationHandler {

    private Consumer consumer = null;

    public GeneratedProxy(Consumer consumer) {
        this.consumer = consumer;
    }

    public Consumer generateProxy() {
        Consumer generatedProxy = null;
        if (consumer != null) {
            Class<? extends Consumer> consumerClass = consumer.getClass();
            generatedProxy =
                (Consumer) Proxy
                    .newProxyInstance(consumerClass.getClassLoader(), consumerClass.getInterfaces(),
                        this);
        }
        return generatedProxy;
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

