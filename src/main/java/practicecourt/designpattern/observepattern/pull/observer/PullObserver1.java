package practicecourt.designpattern.observepattern.pull.observer;

import practicecourt.designpattern.observepattern.pull.subject.ConcreteSubject;
import practicecourt.designpattern.observepattern.pull.subject.Subject;

public class PullObserver1 implements PullObserver {

    @Override
    public void update(Subject subject) {
        ConcreteSubject concreteSubject = (ConcreteSubject) subject;
        System.out.println("接受到通知， 主题颜色 ： " + concreteSubject.getSubjectColor());
    }
}
