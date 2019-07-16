package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo1;

/**
 * http://www.importnew.com/22015.html https://www.jianshu.com/p/23d3f1a2b3c7
 */
public class Test {

    public static void main(String[] args) {
        JDKDynamicHandler handler = new JDKDynamicHandler(new FemaleConsumer());
        Consumer proxy = handler.getConsumerProxy();
        proxy.shopping();
    }
}
