package practicecourt.designpattern.observepattern.push.observer;

public class PushObserver2 implements PushObserver {

    @Override
    public void update() {
        System.out.println("这里是SecondObserver : 通知已到达。");
    }
}
