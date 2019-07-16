package practicecourt.designpattern.factorypattern.abstractfactory.produce;

public class ThirdPartTelevision implements BaseTelevision {

    public ThirdPartTelevision() {
        System.out.println(name() + " : " + desc());
    }

    @Override
    public String name() {
        return "第三方电视机";
    }

    @Override
    public String desc() {
        return "*";
    }
}
