package practice.dev.mt;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    private final int customerId;
    private AtomicInteger balance;

    public BankAccount(int customerId, AtomicInteger openingBalance) {
        this.customerId = customerId;
        this.balance = new AtomicInteger(openingBalance.get());
    }

    /*public void withdraw(int amount) throws OverdrawnException {
        if(amount > balance) {
            throw  new OverdrawnException();
        }
        balance.addAndGet(-amount);
    }

    public void deposit(int amount) {
        balance.addAndGet(amount);
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBalance() {
        return balance.get();
    }

    class TransferOperation extends Thread {
        int threadNum;
        private static Object lock;

        TransferOperation(int threadNum) {
            this.threadNum = threadNum;
        }

        private void transfer(BankAccount fromAccount, BankAccount toAccount, int transferAmount) throws
                OverdrawnException {
            synchronized (lock) {
                fromAccount.withdraw(transferAmount);
                toAccount.deposit(transferAmount);
            }
        }
    }*/
}
