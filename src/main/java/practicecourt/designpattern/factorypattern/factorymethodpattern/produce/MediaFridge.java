package practicecourt.designpattern.factorypattern.factorymethodpattern.produce;

public class MediaFridge implements BaseProduce {

    public MediaFridge() {
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
