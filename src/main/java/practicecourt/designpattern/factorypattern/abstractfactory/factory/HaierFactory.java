package practicecourt.designpattern.factorypattern.abstractfactory.factory;

import practicecourt.designpattern.factorypattern.abstractfactory.produce.*;

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
