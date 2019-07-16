package practicecourt.designpattern.observepattern.push.subject;

import practicecourt.designpattern.observepattern.push.observer.PushObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    public static List<PushObserver> observers = new ArrayList<>();

    public abstract void notifyObservers();

    public void attach(PushObserver observer) {
        observers.add(observer);
    }

    public void detach(PushObserver observer) {
        if (observers.indexOf(observer) >= 0) {
            observers.remove(observer);
        }
    }
}
