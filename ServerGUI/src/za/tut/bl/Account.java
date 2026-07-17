
package za.tut.bl;


public class Account {
    private int accountNo;
    private double amount;

    public Account() {
    }

    public Account(int accountNo, double amount) {
        this.accountNo = accountNo;
        this.amount = amount;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
