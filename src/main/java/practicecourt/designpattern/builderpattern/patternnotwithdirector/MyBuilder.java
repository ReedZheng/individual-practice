package practicecourt.designpattern.builderpattern.patternnotwithdirector;

public class MyBuilder {

    private String mainEngine;
    private String displayer;
    private String ioEquipment;

    private MyBuilder() {
    }

    public static MyBuilder newInstance() {
        return new MyBuilder();
    }

    public MyBuilder buildPartA(String param) {
        mainEngine = param;
        return this;
    }

    public MyBuilder buildPartB(String param) {
        displayer = param;
        return this;
    }

    public MyBuilder buildPartC(String param) {
        ioEquipment = param;
        return this;
    }

    public Computer build() {
        Computer computer = Computer.getInstance();
        computer.setDisplayer(displayer);
        computer.setIoEquipment(ioEquipment);
        computer.setMainEngine(mainEngine);
        return computer;
    }
}
