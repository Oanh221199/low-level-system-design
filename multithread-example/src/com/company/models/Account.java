package com.company.models;

public class Account {
    private  Integer balance;

    public Account(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public synchronized  void deposit(Integer amount, User user){
        this.balance += amount;
        System.out.println( user.toString() + "  deposited:  " + amount + "|" + "balance: " + this.balance);
    }

    public synchronized  boolean withdraw(Integer amount, User user){
        if (amount> this.balance){
            System.out.println("You do not have enough balance to withdraw this amount"+ "|" + "balance: " + this.balance);
            return  false;
        }
        this.balance -= amount;
        System.out.println( user.toString() + "  withdraw:  " + amount + "|" + "balance: " + this.balance);
        return  true;
    }

}
