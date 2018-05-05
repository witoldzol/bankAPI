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
        //get list of all accounts 
        ArrayList a = c.getAccounts();
        if(a.size() == 0){
            return null;
        } else {
            return a;
        }
    }
    
    //return balance of account (by acc number)
    public String getBalance(ArrayList<Account> al, int accountNumber){
        int balance;
        String s;
        
        for (Account account : al) {
            if(account.getNumber() == accountNumber){
                balance = account.getCurrentBalance();
                return s = "Balance of account number " + accountNumber + " is : " + balance;
            }
            else{
                return "Unable to find any balance";
            }
                    
        }
        return "Unable to find any balance";
    }
    
    
    //create account for given customer
    public Account createAccount(int id, Account a){
        //get customer
        Customer c = customers.get(id - 1);
        //create account ( method returns String response with a/c type and number)
        return c.createAccount(a);
    }
    
    //delete account by account number
    public void deleteAccount(int id, Account a){
        //get customer
        Customer c = customers.get(id - 1);
        //return updated account
        c.deleteAccount(a);
    }
    
    //delete account by id number ( order in array )
    public void deleteAccount(int id, int accountId){
        Customer c = customers.get(id - 1);
        c.getAccounts().remove(accountId);
    }
}
