package practicecourt.designpattern.builderpattern.patternwithdirector;

public class ConcreteBuilder extends AbstractBuilder {

    @Override
    public AbstractBuilder buildPartA() {
        computer.setDisplayer("品牌1显示器");
        return this;
    }

    @Override
    public AbstractBuilder buildPartB() {
        computer.setIoEquipment("雷柏键鼠套装");
        return this;
    }

    @Override
    public AbstractBuilder buildPartC() {
        computer.setMainEngine("某品牌主机");
        return this;
    }

}
