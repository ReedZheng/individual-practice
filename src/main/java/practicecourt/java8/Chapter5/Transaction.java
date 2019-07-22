package practicecourt.java8.Chapter5;

import java.math.BigDecimal;

/**
 * @Description:
 * @Date: 2018/12/6
 */
public class Transaction {
    private String transactionDate;
    private BigDecimal transactionAmount;
    private Traders traders;

    public Transaction(String transactionDate, BigDecimal transactionAmount, Traders traders) {
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.traders = traders;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Traders getTraders() {
        return traders;
    }

    public void setTraders(Traders traders) {
        this.traders = traders;
    }

    @Override
    public String toString() {
        return "Transaction{" + "transactionDate=" + transactionDate + ", transactionAmount=" + transactionAmount
            + ", traders=" + traders + '}';
    }
}
