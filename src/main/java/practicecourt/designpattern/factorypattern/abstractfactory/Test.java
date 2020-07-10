package practicecourt.designpattern.factorypattern.abstractfactory;

import practicecourt.designpattern.factorypattern.abstractfactory.factory.BaseFactory;
import practicecourt.designpattern.factorypattern.abstractfactory.factory.HaierFactory;
import practicecourt.designpattern.factorypattern.abstractfactory.factory.MediaFactory;
import practicecourt.designpattern.factorypattern.abstractfactory.factory.ThirdPartFactory;

/**
 * 抽象工厂，拓展工厂容易，拓展产品麻烦
 */
public class Test {

    public static void main(String[] args) {
        BaseFactory baseFactory = new HaierFactory();
        baseFactory.createFridge();
        baseFactory.createAirConditioner();
        ((HaierFactory) baseFactory).createTelevision();

        baseFactory = new MediaFactory();
        baseFactory.createFridge();
        baseFactory.createAirConditioner();

        baseFactory = new ThirdPartFactory();
        baseFactory.createFridge();
        baseFactory.createAirConditioner();
        ((ThirdPartFactory) baseFactory).createTelevision();
    }
}
