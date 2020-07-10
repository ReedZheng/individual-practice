package practicecourt.designpattern.factorypattern.abstractfactory.factory;

import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseFridge;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseTelevision;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.HaierFridge;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.MediaAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.ThirdPartTelevision;

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
