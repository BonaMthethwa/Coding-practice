
package za.tut.bl;


public class AccountManager implements AccountInterface {

    public AccountManager() {
    }
    
    

    @Override
    public synchronized String deposit(Account acc) {
        double moneyDeposited = 0;
        double moneyInAccount=acc.getAmount();
        int accountNo=acc.getAccountNo();
        
        double totMoney=moneyInAccount+moneyDeposited;
        return "The amount of R"+moneyDeposited+" was deposited into account number "+ accountNo;
    }

    @Override
    public synchronized String withdraw(Account acc) {
         double moneyDeposited = 0;
        double moneyInAccount=acc.getAmount();
        int accountNo=acc.getAccountNo();
        
        double totMoney=moneyInAccount-moneyDeposited;
        return "The amount of R"+moneyDeposited+" was withdrew from account number "+ accountNo;
        
    }

    @Override
    public synchronized String getBalance(Account acc) {
        double moneyInAccount=acc.getAmount();
        int accountNo=acc.getAccountNo();
        return "The money in account number "+accountNo+ " is R"+moneyInAccount;
    }
    
}
