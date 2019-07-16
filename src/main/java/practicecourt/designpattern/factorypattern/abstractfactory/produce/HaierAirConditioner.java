package practicecourt.designpattern.factorypattern.abstractfactory.produce;

public class HaierAirConditioner implements BaseAirConditioner {

    public HaierAirConditioner() {
        System.out.println(printName() + " : " + printDesc());
    }

    @Override
    public String printName() {
        return "海尔空调";
    }

    @Override
    public String printDesc() {
        return "*****";
    }
}
