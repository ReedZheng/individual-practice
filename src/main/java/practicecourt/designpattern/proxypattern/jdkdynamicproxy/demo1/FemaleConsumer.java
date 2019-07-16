package practicecourt.designpattern.proxypattern.jdkdynamicproxy.demo1;

public class FemaleConsumer implements Consumer {

    @Override
    public void shopping() {
        System.out.println("-- 购买xx --");
    }
}
