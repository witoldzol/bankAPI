/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.services.AccountServices;
import com.bank.services.CustomerServices;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author witold
 */
// this is a sub resource, 
// path param is already defined in parent file
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AccountResources {
    
    //instantiate customer services
    AccountServices as = new AccountServices();
   
    //create account 
    @POST
    public Account createAccount(@PathParam("id") int id, String type) throws NullPointerException{
        try {
            return as.createAccount(id, type);
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }
    
    //return accounts for given Customer
    @GET
    public ArrayList<Account> getAllAccounts(@PathParam("id") int id) throws NullPointerException{
        ArrayList<Account> al = null;
        try {
            al = as.getAllAccounts(id);
        } catch (Exception e) {
            System.err.println("error: " + e);
        } 
        return al;
    }
    
    //return specific account for customer
    @GET
    @Path("/{accountNumber}")
    public Account getAccount(@PathParam("id") int id, 
                              @PathParam("accountNumber") int accountNumber) 
                              throws NullPointerException
    {
        ArrayList<Account> al = null;
        try {
            al = as.getAllAccounts(id);
            return as.getAccount(al, accountNumber);
            
        } catch (Exception e) {
            System.err.println("error: " + e);
        } 
        return null;
    }
    
    //returns balance of the account as string
    @GET
    @Path("/{accountNumber}/balance")
    public String getBalance(@PathParam("id") int id,
                             @PathParam("accountNumber") int accountNumber)
    {
        String s;
        //get array of accounts
        ArrayList al = as.getAllAccounts(id);
        //get balance and return it as string
        return  s = as.getBalance(al, accountNumber);
    }
    
    //delete account by account number 
    @DELETE
    public String deleteAccount(@PathParam("id") int id, Account a) {
        int num = a.getNumber();
        as.deleteAccount(id, a); 
       return "Account number" + num + " deleted";
    }
   
    
    //---------------------   Path to TRANSACTIONS sub rescource
    @Path("/{accountNumber}/transactions")
    public TransactionResources getResources(){
        return new TransactionResources();
    }
    
    
}
