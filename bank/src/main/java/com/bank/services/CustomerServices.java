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
 * @author witold
 */
public class CustomerServices {
    
    // initialize list to hold our customers
    private ArrayList<Customer> customers = Database.getCustomers();
   
    //constructor - no parameter
    public CustomerServices () {
       
    }
    
    public Customer createCustomer(Customer c){
        //adjust id number as per list size
        c.setId(customers.size() + 1);
        //add customer to the list
        customers.add(c);    
        return customers.get(customers.size() - 1);
    }
    
    public ArrayList<Customer> getAllCustomers(){
        return customers;
    }
    
    public Customer getCustomer(int id){
        return customers.get(id -1);
    }

    public Customer updateCustomer(int id, Customer c){
        
        if (id <= 0) {
            return null;
        }
        //update customer data
        customers.set(id - 1, c);
        //return customer object
        return customers.get(id - 1 );
    }
    
    public Customer removeCustomer(int id){
        if (id == 0) {
            return null;
        }
        //get customer
        Customer c = customers.get(id-1);
        //remove it from list
        customers.remove(id-1);
        //print out
        System.out.println("Customer Id " + id + " has been removed");
        //return removed object
        return c;
    }
    
    
    
    
}