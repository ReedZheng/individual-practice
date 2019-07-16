package practicecourt.designpattern.singleinstancepattern.staticinnerclass;

public class StaticInnerWay {

    private static class Inner {
        private static StaticInnerWay staticInnerWay = new StaticInnerWay();
    }

    private StaticInnerWay() {
    }

    public static StaticInnerWay getInstance() {
        return Inner.staticInnerWay;
    }

}
