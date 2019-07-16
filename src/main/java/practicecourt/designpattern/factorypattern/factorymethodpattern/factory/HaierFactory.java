package practicecourt.designpattern.factorypattern.factorymethodpattern.factory;

import practicecourt.designpattern.factorypattern.factorymethodpattern.produce.HaierFridge;

public class HaierFactory implements BaseFactory {

    @Override
    public HaierFridge createProduce() {
        return new HaierFridge();
    }
}
