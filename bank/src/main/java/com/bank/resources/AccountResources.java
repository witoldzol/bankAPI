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

// this is a sub resource, 
// path param is already defined in parent file
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResources {
    
    //instantiate customer services
    AccountServices as = new AccountServices();
   
    //create account 
    @POST
    public Account getCustomers(@PathParam("id") int id, Account a) throws NullPointerException{
        try {
            return as.createAccount(id, a);
        } catch (Exception e) {
            System.err.println(e);
        }
        return a;
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
    @Path("/{accountId}")
    public Account getAccount(@PathParam("id") int id, 
                              @PathParam("accountId") int accountId) 
                              throws NullPointerException
    {
        ArrayList<Account> al = null;
        try {
            return as.getAllAccounts(id).get(accountId);
            
        } catch (Exception e) {
            System.err.println("error: " + e);
        } 
        return null;
    }
    
    //delete account by account number 
    @DELETE
    public String deleteAccount(@PathParam("id") int id, Account a) {
       as.deleteAccount(id, a); 
       return "Account number" + a.getNumber() + " deleted";
    }
    
    //delete account by id number (order in array list)
    @DELETE
    @Path("/{accountId}")
    public String deleteAccount(@PathParam("id") int id,
                                @PathParam("accountId") int accountId)
                                throws NullPointerException
    {
        try {
            as.deleteAccount(id, accountId);
            return "Account id " + accountId + " has been deleted";
        } catch (Exception e) {
            System.err.println("error: " + e);
        }
        return null;
    }
    
    //---------------------   Path to TRANSACTIONS sub rescource
    @Path("/{id}/accounts/transactions")
    public AccountResources getResources(){
        return new AccountResources();
    }
    
    
}
