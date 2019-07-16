package practicecourt.designpattern.singleinstancepattern.doublechecklock;

public class DCLWay {

    // 在 jdk1.5 以后，volative 保证了可见性并且可以阻止指令重排序。
    private static volatile DCLWay dclWay = null;

    private DCLWay() {
    }

    public static DCLWay getInstance() {
        if (dclWay == null) {
            synchronized (DCLWay.class) {
                if (dclWay == null) {
                    dclWay = new DCLWay();
                }
            }
        }
        return dclWay;
    }

}
