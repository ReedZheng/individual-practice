package practicecourt.designpattern.observepattern.push;

import practicecourt.designpattern.observepattern.push.observer.PushObserver;
import practicecourt.designpattern.observepattern.push.observer.PushObserver1;
import practicecourt.designpattern.observepattern.push.observer.PushObserver2;
import practicecourt.designpattern.observepattern.push.subject.ConcreteSubject;
import practicecourt.designpattern.observepattern.push.subject.Subject;

public class TestPush {

    public static void main(String[] args) {
        // 观察者 - 推模式，主题向观察者推送信息 不管观察者是否需要。
        Subject subject = new ConcreteSubject();
        PushObserver o1 = new PushObserver1();
        PushObserver o2 = new PushObserver2();
        subject.attach(o1);
        subject.attach(o2);
        subject.notifyObservers();

    }
}
