package practicecourt.designpattern.factorypattern.abstractfactory.produce;

public class MediaFridge implements BaseFridge {

    public MediaFridge() {
        System.out.println(printName() + " : " + printDesc());
    }

    @Override
    public String printName() {
        return "美的电冰箱";
    }

    @Override
    public String printDesc() {
        return "****";
    }
}
