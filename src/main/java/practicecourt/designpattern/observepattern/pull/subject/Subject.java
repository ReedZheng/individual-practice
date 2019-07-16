package practicecourt.designpattern.observepattern.pull.subject;

import practicecourt.designpattern.observepattern.pull.observer.PullObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    public static List<PullObserver> list = new ArrayList<>();

    public abstract void notifyObservers();

    public void attach(PullObserver o) {
        list.add(o);
    }

    public void remove(PullObserver o) {
        if (list.indexOf(o) >= 0) {
            list.remove(o);
        }
    }
}
