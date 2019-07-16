package practicecourt.designpattern.statepattern;

public class NormalState extends State {

    public NormalState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdrawn(Double amount) {
        account.setBalance(account.getBalance() - amount);
        changeState();
    }

    @Override
    public void changeState() {
        if (account.getBalance() < 0 && account.getBalance() > -2000) {
            account.setState(new ArrearageState(account));
        }
        if (account.getBalance() <= -2000) {
            account.setState(new FreezeState(account));
        }
    }
}
