/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.database.Database;
import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.models.Transaction;
import java.util.ArrayList;

/**
 *
 * @author witold
 */
public class TransactionServices {
    
    //get data from 'database'
    private ArrayList<Customer> customers = Database.getCustomers();
    
    public Transaction createTransaction(Account a, Transaction t){
        ArrayList tl = a.getTransactions();
        tl.add(t);
        return t;
    }
    
    //get transaction that maches amount for given account
    public Transaction getTransaction(Account a, double amount) {
        ArrayList<Transaction> tl = a.getTransactions();
        for (Transaction transaction : tl) {
            if (transaction.getAmount() == amount) {
                return transaction;
            }
        }
        return null;
    }
}
