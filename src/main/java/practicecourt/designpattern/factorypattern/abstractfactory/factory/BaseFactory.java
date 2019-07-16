package practicecourt.designpattern.factorypattern.abstractfactory.factory;

import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseFridge;

public interface BaseFactory {

    BaseFridge createFridge();

    BaseAirConditioner createAirConditioner();
}
