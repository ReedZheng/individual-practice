package practicecourt.designpattern.proxypattern.dynamicproxy;

public class FemaleConsumer implements Consumer {

    @Override
    public void shopping() {
        System.out.println("-- 购买xx --");
    }

    @Override
    public void travel() {
        System.out.println("-- 旅游 --");
    }
}
