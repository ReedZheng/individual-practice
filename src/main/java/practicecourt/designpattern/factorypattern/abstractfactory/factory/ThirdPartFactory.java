package practicecourt.designpattern.factorypattern.abstractfactory.factory;

import practicecourt.designpattern.factorypattern.abstractfactory.produce.*;

public class ThirdPartFactory implements BaseFactory {

    @Override
    public BaseFridge createFridge() {
        return new HaierFridge();
    }

    @Override
    public BaseAirConditioner createAirConditioner() {
        return new MediaAirConditioner();
    }

    public BaseTelevision createTelevision() {
        return new ThirdPartTelevision();
    }
}
