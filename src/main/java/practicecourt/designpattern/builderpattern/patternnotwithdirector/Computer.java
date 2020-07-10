package practicecourt.designpattern.builderpattern.patternnotwithdirector;

public class Computer {

    private String mainEngine;
    private String displayer;
    private String ioEquipment;

    private Computer() {
    }

    ;

    public static Computer getInstance() {
        return new Computer();
    }

    public void setMainEngine(String mainEngine) {
        this.mainEngine = mainEngine;
    }

    public void setDisplayer(String displayer) {
        this.displayer = displayer;
    }

    public void setIoEquipment(String ioEquipment) {
        this.ioEquipment = ioEquipment;
    }

    @Override
    public String toString() {
        return "Computer{" + "mainEngine='" + mainEngine + '\'' + ", displayer='" + displayer + '\''
            + ", ioEquipment='"
            + ioEquipment + '\'' + '}';
    }
}
