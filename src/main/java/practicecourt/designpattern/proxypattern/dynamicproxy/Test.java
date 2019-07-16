package practicecourt.designpattern.proxypattern.dynamicproxy;

/**
 * http://www.importnew.com/22015.html https://www.jianshu.com/p/23d3f1a2b3c7
 */
public class Test {

    public static void main(String[] args) {
        GeneratedProxy handler = new GeneratedProxy(new FemaleConsumer());
        Consumer proxyConsumer = handler.generateProxy();
        proxyConsumer.shopping();
        proxyConsumer.travel();
    }
}
