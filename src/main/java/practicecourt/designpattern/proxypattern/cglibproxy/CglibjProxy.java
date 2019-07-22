package practicecourt.designpattern.proxypattern.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Date: 2018/11/28
 */
public class CglibjProxy {

    static <T> Object getProxy(T t) {
        Enhancer en = new Enhancer();
        en.setSuperclass(t.getClass());
        en.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                throws Throwable {
                System.out.println("方法执行前..");
                Object obj = methodProxy.invoke(t, objects);
                System.out.println("方法执行后..");
                return obj;
            }
        });
        Object proxy = en.create();
        return proxy;
    }
}
