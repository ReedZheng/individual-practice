package practicecourt.designpattern.statepattern;

/**
 * 欠费
 */
public class ArrearageState extends State {

    public ArrearageState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(Double amount) {
        account.setBalance(account.getBalance() + amount);
        changeState();
    }

    @Override
    public void withdrawn(Double amount) {
        account.setBalance(account.getBalance() - amount);
        changeState();
    }

    @Override
    public void changeState() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(account));
        }
        if (account.getBalance() <= -2000) {
            account.setState(new FreezeState(account));
        }
    }
}
