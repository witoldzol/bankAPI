/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.models.Customer;
import java.util.ArrayList;
import java.util.List;


public class CustomerServices {
    
    // initialize list to hold our customers
    public static List<Customer> list = new ArrayList<>();
   
    //constructor - no parameter
    public CustomerServices () {
       
    }
    
    public List<Customer> createCustomer(Customer c){
        
        //adjust id number as per list size
        c.setId(list.size() + 1);
        
        //add customer to the list
        list.add(c);    
        
        //debuging print out 
        System.err.println("Customer " + c.toString() + "has been added" );
        
        return list;
    }
    
    public List<Customer> getAllCustomers(){
        return list;
    }
    
    public Customer getCustomer(int id){
        return list.get(id -1);
    }

    public Customer updateCustomer(Customer c){
        
        if (c.getId() == 0) {
            return null;
        }
        //update customer data
        list.set(c.getId()-1, c);
        //debugging print out
        System.out.println("Customer id " + c.getId() + " has been updated");
        //return customer object
        return c;
    }
    
    public Customer removeCustomer(int id){
        if (id == 0) {
            return null;
        }
        //get customer
        Customer c = list.get(id-1);
        //remove it from list
        list.remove(id-1);
        //print out
        System.out.println("Customer Id " + id + " has been removed");
        //return removed object
        return c;
    }
    /*
    


    public Customer deleteBook(int id){
        if (id <= 0) {
            return null;
        }
        Customer b = list.get(id-1);
        list.remove(id-1);
        System.out.println("204 -  book id:" + String.valueOf(id) + " deleted");
        return b;
    }
    */
}