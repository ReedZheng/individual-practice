package practicecourt.designpattern.factorypattern.abstractfactory.produce;

public class HaierTelevision implements BaseTelevision {

    public HaierTelevision() {
        System.out.println(name() + " : " + desc());
    }

    @Override
    public String name() {
        return "海尔电视机";
    }

    @Override
    public String desc() {
        return "***";
    }
}
