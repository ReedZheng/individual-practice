package practicecourt.designpattern.proxypattern.cglibproxy;

/**
 * @Description:
 * @Date: 2018/11/28
 */
public class Test {

    public static void main(String[] args) {
        Target proxy = (Target) CglibjProxy.getProxy(new Target());
        proxy.method1();
    }
}
