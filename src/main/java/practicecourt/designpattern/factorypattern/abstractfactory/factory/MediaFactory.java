package practicecourt.designpattern.factorypattern.abstractfactory.factory;

import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.BaseFridge;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.MediaAirConditioner;
import practicecourt.designpattern.factorypattern.abstractfactory.produce.MediaFridge;

public class MediaFactory implements BaseFactory {

    @Override
    public BaseFridge createFridge() {
        return new MediaFridge();
    }

    @Override
    public BaseAirConditioner createAirConditioner() {
        return new MediaAirConditioner();
    }
}
