public class NotEnoughMoneyException extends IllegalStateException {

    private double amount, balance;
    public NotEnoughMoneyException(double amount,double balance) {
        super("You have not enough money to withdraw "+ amount + "$");
        this.amount = amount;
        this.balance = balance;
    }

    public double getAmount(){
        return amount;
    }

    public double getBalance(){
        return balance;
    }
    public double getMissingAmount(){
        return amount-balance;
    }

}
