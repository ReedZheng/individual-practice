package practicecourt.designpattern.statepattern;

public class FreezeState extends State {

    public FreezeState(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(Double amount) {
        account.setBalance(account.getBalance() + amount);
        changeState();
    }

    @Override
    public void withdrawn(Double amount) {
        System.out.println("you can't do this");
    }

    @Override
    public void changeState() {
        if (account.getBalance() > -2000 && account.getBalance() < 0) {
            account.setState(new ArrearageState(account));
        }
        if (account.getBalance() > 0) {
            account.setState(new NormalState(account));
        }
    }
}
