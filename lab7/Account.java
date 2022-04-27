public class Account {

    //variable d'instance
    private double balance;

    //contructeur
    public Account(){
        this.balance = 0;
    }

    public void deposit(double value){
        this.balance += value;
        System.out.println(getBalance());
    }

    public void withdraw(double value){
        if(getBalance()<value){
            throw new NotEnoughMoneyException(value, balance);
        }
        this.balance -= value;

        System.out.println(getBalance());
    }

    public double getBalance(){
        return balance;
    }

}
