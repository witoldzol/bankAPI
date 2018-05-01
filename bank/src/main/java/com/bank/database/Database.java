/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.database;

import com.bank.models.Customer;
import java.util.ArrayList;


public class Database {
    
    private static ArrayList<Customer> customers = new ArrayList();
    
    public static ArrayList<Customer> getCustomers(){
        return customers;
    }
    
}
