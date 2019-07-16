package practicecourt.designpattern.observepattern.pull.observer;

import practicecourt.designpattern.observepattern.pull.subject.Subject;

public interface PullObserver {

    void update(Subject subjectObj);
}
