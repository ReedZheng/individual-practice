package practicecourt.designpattern.observepattern.push.observer;

public class PushObserver1 implements PushObserver {

    @Override
    public void update() {
        System.out.println("这里是FirstObserver : 通知已到达。");
    }
}
