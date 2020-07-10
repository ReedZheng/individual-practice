package practicecourt.designpattern.factorypattern.abstractfactory.factory;

import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseFridge;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseTelevision;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.HaierAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.HaierFridge;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.HaierTelevision;

public class HaierFactory implements BaseFactory {

    @Override
    public BaseFridge createFridge() {
        return new HaierFridge();
    }

    @Override
    public BaseAirConditioner createAirConditioner() {
        return new HaierAirConditioner();
    }

    public BaseTelevision createTelevision() {
        return new HaierTelevision();
    }
}
