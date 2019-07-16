package practicecourt.designpattern.factorypattern.factorymethodpattern.factory;

import practicecourt.designpattern.factorypattern.factorymethodpattern.produce.BaseProduce;
import practicecourt.designpattern.factorypattern.factorymethodpattern.produce.MediaFridge;

public class MediaFactory implements BaseFactory {

    @Override
    public BaseProduce createProduce() {
        return new MediaFridge();
    }
}
