/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.models.Account;
import com.bank.models.Customer;
import static com.bank.services.CustomerServices.list;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eldrad
 */
public class AccountServices {
    
    // ???????????????????????????????????????????
    // initialize list to hold our customers
    public List<Customer> list = new CustomerServices().getAllCustomers();
    
    //list all accounts for single customer
    public List<Account> getAllAccounts(int id){
        //get customer
        Customer c = list.get(id -1);
        
        System.err.println("number of accounts is : " + list.size() );
        //get list of all accounts 
        return c.getAccounts();
        
    }
    
    //create account for given customer
    public Account createAccount(int id, Account a){
        //get customer
        Customer c = list.get(id - 1);
        //create account ( method returns String response with a/c type and number)
        return c.createAccount(a);
    }
    
    
}
