/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.database.Database;
import com.bank.models.Account;
import com.bank.models.Customer;
import java.util.ArrayList;

/**
 *
 * @author eldrad
 */
public class AccountServices {
    
    //get data from 'database'
    private ArrayList<Customer> customers = Database.getCustomers();
    
    //list all accounts for single customer
    public ArrayList<Account> getAllAccounts(int id){
        //get customer
        Customer c = customers.get(id -1);
        
        System.err.println("number of accounts is : " + c.getAccounts().size() );
        //get list of all accounts 
        ArrayList a = c.getAccounts();
        
        if(a.size() == 0){
            return null;
        } else {
            return a;
        }
        
    }
    
    //create account for given customer
    public Account createAccount(int id, Account a){
        //get customer
        Customer c = customers.get(id - 1);
        //create account ( method returns String response with a/c type and number)
        return c.createAccount(a);
    }
    
    
}
