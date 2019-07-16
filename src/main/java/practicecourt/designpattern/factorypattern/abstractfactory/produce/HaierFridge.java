package practicecourt.designpattern.factorypattern.abstractfactory.produce;

public class HaierFridge implements BaseFridge {

    public HaierFridge() {
        System.out.println(printName() + " : " + printDesc());
    }

    @Override
    public String printName() {
        return "海尔电冰箱";
    }

    @Override
    public String printDesc() {
        return "***";
    }
}
