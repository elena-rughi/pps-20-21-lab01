package lab01.example.model;

public class SimpleBankAccountWithATM extends BaseBankAccount{
    private static final double FEE_AMOUNT = 1;

    public SimpleBankAccountWithATM(double balance, AccountHolder holder) {
        super(balance, holder);
    }

    public void depositATM(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount - FEE_AMOUNT;
        }
    }

    public void withdrawATM(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance += - amount - FEE_AMOUNT;
        }
    }

    @Override
    protected boolean isWithdrawAllowed(double amount) {
        return this.balance >= amount + FEE_AMOUNT;
    }
}
