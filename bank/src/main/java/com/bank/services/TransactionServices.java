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
 * @author eldrad
 */
public class TransactionServices {
    
    //get data from 'database'
    private ArrayList<Customer> customers = Database.getCustomers();
    
    public Transaction createTransaction( int customerId, int accountId, Transaction t){
        Customer c = customers.get(customerId - 1);
        Account a = c.getAccounts().get(accountId);
        ArrayList tl = a.getTransactions();
        tl.add(t);
        return t;
    }
    
    
}
