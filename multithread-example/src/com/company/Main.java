package com.company;

import com.company.models.Account;
import com.company.models.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);
        List<Thread> depositThreads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User  user = new User("User_" + i);
            Thread depositThread = new Thread(()->{
                account.deposit(3, user);
            });
            depositThreads.add(depositThread);

        }
        // start thread deposit
        for (Thread depositThread:depositThreads) {
            depositThread.start();
        }

        // waiting finish depositThreads
        for (Thread depositThread:depositThreads) {
            depositThread.join();
        }

        // Get balance after deposit
        System.out.println("Balance after deposit: " + account.getBalance());

        // Create 5 user withdraw

        List<Thread> withdrawThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User  user = new User("User_" + i);
            Thread withdrawThread = new Thread(()->{
                account.withdraw(100, user);
            });
            withdrawThreads.add(withdrawThread);

        }
        // start thread withdraw
        for (Thread withdrawThread:withdrawThreads) {
            withdrawThread.start();
        }

        // waiting finish withdrawThreads
        for (Thread withdrawThread:withdrawThreads) {
            withdrawThread.join();
        }
        // Get balance after withdraw
        System.out.println("Balance after withdraw: " + account.getBalance());


    }
}
