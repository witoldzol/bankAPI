/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Account;
import com.bank.services.AccountServices;
import com.bank.services.CustomerServices;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/{id}/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResources {
    
    //instantiate customer services
    AccountServices as = new AccountServices();
    
    @GET
    public String test(){
        return "test";
    }
    
    //list all accounts for given customer
    @GET
    public List<Account> getAllAccounts(@PathParam("id") int id){
        return as.getAllAccounts(id);
    }
    
    //create account
    @POST
    public Account createAccount(@PathParam("id") int id, Account a){
        return createAccount(id, a);
    }
    
}
