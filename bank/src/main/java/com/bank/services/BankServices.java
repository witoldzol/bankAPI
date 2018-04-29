/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.models.Customer;
import java.util.ArrayList;
import java.util.List;


public class BankServices {
    
    public static List<Customer> list = new ArrayList<>();
   
    
    public BankServices () {
       
    }
    
    public List<Customer> createCustomer(Customer c){
        
        list.add(c);    
        
        System.out.println("size of list " + list.size());
        //System.out.println("Added customer with id of " + c.getId());
        return list;
    }
    
    public List<Customer> getAllCustomers(){
        return list;
    }
    
    public Customer getCustomer(int id){
        return list.get(id -1);
    }

    /*
    public List<Customer> getAllBooks() {
        return list;
    }

    public Customer createBook(Customer book){
        book.setId(list.size() + 1);
        list.add(book);
        System.err.println("size of list is " + list.size());
        System.out.println("201 -  book create with id:" + String.valueOf(book.getId()));
        return book;
    }
        
    public Customer readBook(int id) {
        return list.get(id-1);
    }
     
    public Customer updateBook(Customer book){
        if (book.getId() <= 0) {
            return null;
        }
        list.set(book.getId()-1, book);
        System.out.println("200 -  book id:" + String.valueOf(book.getId()) + " updated");
        return book;
    }
    
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