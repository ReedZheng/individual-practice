package practicecourt.java8.Chapter6;

/**
 * @Description:
 * @Date: 2018/12/6
 */
public class Transaction {
    private String transactionAddr;
    private Currency amount;
    private Boolean isSuccess;

    public Transaction(String transactionAddr, Currency amount, Boolean isSuccess) {
        this.transactionAddr = transactionAddr;
        this.amount = amount;
        this.isSuccess = isSuccess;
    }

    public String getTransactionAddr() {
        return transactionAddr;
    }

    public void setTransactionAddr(String transactionAddr) {
        this.transactionAddr = transactionAddr;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionAddr='" + transactionAddr + '\'' + ", amount=" + amount + ", isSuccess="
            + isSuccess + '}';
    }
}
