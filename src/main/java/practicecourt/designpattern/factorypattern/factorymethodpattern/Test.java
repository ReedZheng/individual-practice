package practicecourt.designpattern.factorypattern.factorymethodpattern;

import practicecourt.designpattern.factorypattern.factorymethodpattern.factory.BaseFactory;
import practicecourt.designpattern.factorypattern.factorymethodpattern.factory.HaierFactory;
import practicecourt.designpattern.factorypattern.factorymethodpattern.factory.MediaFactory;

/**
 * 工厂方法模式，符合开闭，但是成对增加类
 */
public class Test {

    public static void main(String[] args) {
        BaseFactory baseFactory = new HaierFactory();
        baseFactory.createProduce();

        baseFactory = new MediaFactory();
        baseFactory.createProduce();
    }
}
