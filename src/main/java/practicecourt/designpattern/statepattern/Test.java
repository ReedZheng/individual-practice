package practicecourt.designpattern.statepattern;

public class Test {

    public static void main(String[] args) {
        Account account = new Account(500.00, "marx");
        State state = new NormalState(account);

        account.deposit(1000.00);
        account.withdrawn(1800.00);
        account.deposit(500.00);
        account.withdrawn(3000.00);
        account.withdrawn(100.00);
        account.deposit(5000.00);
        account.withdrawn(100.00);
    }
}
