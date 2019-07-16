package practicecourt.designpattern.observepattern.pull;

import practicecourt.designpattern.observepattern.pull.observer.PullObserver;
import practicecourt.designpattern.observepattern.pull.observer.PullObserver1;
import practicecourt.designpattern.observepattern.pull.subject.ConcreteSubject;
import practicecourt.designpattern.observepattern.pull.subject.Subject;

public class TestPull {

    public static void main(String[] args) {
        // 观察者 - 拉模式，
        // 主题对象在通知观察者的时候，只传递少量信息。如果观察者需要更具体的信息，由观察者主动到主题对象中
        // 获取，相当于是观察者从主题对象中拉数据。一般这种模型的实现中，会把主题对象自身通过update()方法
        // 传递给观察者，这样在观察者需要获取数据的时候，就可以通过这个引用来获取了
        Subject subject1 = new ConcreteSubject();
        PullObserver po = new PullObserver1();
        subject1.attach(po);
        subject1.notifyObservers();
    }
}
