package practicecourt.designpattern.observepattern.push.subject;

import practicecourt.designpattern.observepattern.push.observer.PushObserver;

public class ConcreteSubject extends Subject {

    @Override
    public void notifyObservers() {
        for (PushObserver o : observers) {
            o.update();
        }
    }
}
