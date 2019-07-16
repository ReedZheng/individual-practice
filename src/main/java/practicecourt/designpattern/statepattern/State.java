package practicecourt.designpattern.statepattern;

public abstract class State {

    public Account account;

    public abstract void deposit(Double amount);

    public abstract void withdrawn(Double amount);

    public abstract void changeState();
}
