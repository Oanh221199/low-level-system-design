package com.company.models;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    // Use Atomic Interger ( Atomic) thay Integer balance(synchronized)
    private AtomicInteger balance;

    public Account(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    public Integer getBalance() {
        return balance.get();
    }

    public void setBalance(Integer balance) {
        this.balance.set(balance);
    }

    // delete synchronized
    public void deposit(Integer amount, User user){
        // Use AtomicInteger addAndGet change +
        int newBalance = balance.addAndGet(amount);
        System.out.println(user.toString() + " deposited: " + amount + " | balance: " + newBalance);
    }

    public boolean withdraw(Integer amount, User user){
        while (true) {
            // Use AtomicInteger get
            int current = balance.get();
            if (amount > current) {
                System.out.println("You do not have enough balance to withdraw this amount | balance: " + current);
                return false;
            }
            // Use AtomicInteger compareAndSet change compare amount
            boolean updated = balance.compareAndSet(current, current - amount);
            if (updated) {
                System.out.println(user.toString() + " withdraw: " + amount + " | balance: " + (current - amount));
                return true;
            }
        }
    }
}
