package practicecourt.java8.Chapter6;

public class Currency {
    private String type;
    private Integer amountDisplayed;

    public Currency(String type, Integer amountDisplayed) {
        this.type = type;
        this.amountDisplayed = amountDisplayed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmountDisplayed() {
        return amountDisplayed;
    }

    public void setAmountDisplayed(Integer amountDisplayed) {
        this.amountDisplayed = amountDisplayed;
    }

    @Override public String toString() {
        return "Currency{" + "type='" + type + '\'' + ", amountDisplayed=" + amountDisplayed + '}';
    }
}
