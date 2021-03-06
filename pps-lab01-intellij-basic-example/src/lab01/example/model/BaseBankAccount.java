package lab01.example.model;

public abstract class BaseBankAccount implements BankAccount {
    protected final AccountHolder holder;
    protected double balance;

    public BaseBankAccount(final double balance, final AccountHolder holder) {
        this.balance = balance;
        this.holder = holder;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    protected abstract boolean isWithdrawAllowed(final double amount);
}
