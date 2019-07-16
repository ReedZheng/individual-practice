package practicecourt.designpattern.factorypattern.factorymethodpattern.produce;

public class HaierFridge implements BaseProduce {

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
