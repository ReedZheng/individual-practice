package practicecourt.designpattern.statepattern;

public class Account {

    private Double balance;
    private String acName;
    private State state;

    public Account(Double balance, String acName) {
        this.balance = balance;
        this.acName = acName;
        setState(new NormalState(this));
    }

    public void deposit(Double amount) {
        System.out.println("当前余额：" + getBalance() + "，存入：" + amount);
        state.deposit(amount);
        System.out.println("余额：" + getBalance());
    }

    public void withdrawn(Double amount) {
        System.out.println("当前余额：" + getBalance() + "，取出：" + amount);
        state.withdrawn(amount);
        System.out.println("余额：" + getBalance());
    }

    public void setState(State state) {
        this.state = state;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
