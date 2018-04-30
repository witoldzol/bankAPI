/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Account;
import com.bank.models.Customer;
import com.bank.services.BankServices;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankResources {
    
    //instantiate customer services
    BankServices cs = new BankServices();
    
    //get single customer
    @GET
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id){
        return cs.getCustomer(id);
    }
    //get all customers
    @GET
    public List<Customer> getAllCustomers(){
        return cs.getAllCustomers();
    }
    //create customer
    @POST
    public Customer createCustomer(Customer c) {       
        cs.createCustomer(c);
        return c;
    }
    //update customer
    @PUT
    public Customer updateCustomer(Customer c){
        cs.updateCustomer(c);
        return c;
    }
    //delete customer
    @DELETE
    @Path("/{id}")
    public Customer removeCustomer(@PathParam("id") int id){        
        return cs.removeCustomer(id);        
    }
    //---------------------   ACCOUNTS
    
    //list all accounts for given customer
    @GET
    @Path("/{id}/accounts")
    public List<Account> getAllAccounts(@PathParam("id") int id){
        return cs.getAllAccounts(id);
    }
    
    //create account
    @POST
    @Path("/{id}/accounts")
    public Account createAccount(@PathParam("id") int id, Account a){
        return createAccount(id, a);
    }

}
