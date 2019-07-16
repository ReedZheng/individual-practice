package practicecourt.designpattern.observepattern.pull.subject;

import practicecourt.designpattern.observepattern.pull.observer.PullObserver;

public class ConcreteSubject extends Subject {

    private String subjectColor = "red";

    public String getSubjectColor() {
        return subjectColor;
    }

    @Override
    public void notifyObservers() {
        for (PullObserver po : list) {
            po.update(this);
        }
    }
}
