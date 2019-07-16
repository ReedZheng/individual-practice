package practicecourt.designpattern.factorypattern.abstractfactory.produce;

public class MediaAirConditioner implements BaseAirConditioner {

    public MediaAirConditioner() {
        System.out.println(printName() + " : " + printDesc());
    }

    @Override
    public String printName() {
        return "美的空调";
    }

    @Override
    public String printDesc() {
        return "****";
    }
}
