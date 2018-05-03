/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Account;
import com.bank.models.Transaction;
import com.bank.services.AccountServices;
import com.bank.services.TransactionServices;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author eldrad
 */
public class TransactionResources {
    
    //instantiate customer services
    TransactionServices ts = new TransactionServices();
    //instantiate account services
    AccountServices as = new AccountServices();
    
    //get all transactions for given account
    @GET
    public ArrayList<Transaction> getAllTransactions(@PathParam("id") int id, 
                                                     @PathParam("accountId") int accountId)
                                                     throws NullPointerException
    {
        try
        {
            Account a = as.getAllAccounts(id).get(accountId);
            return a.getTransactions();
        } 
        catch(NullPointerException e){
            System.err.println(e);
        }
        return null;
    }
    
    //create transaction
    @POST
    public Transaction createTransaction(@PathParam("id") int id,
                                         @PathParam("accountId") int accountId,
                                         Transaction t)
    {
        System.out.println("id" + id);
        System.out.println("accountid" + accountId);
        System.out.println("transaction" + t);
        
        return ts.createTransaction(id, accountId, t);
        
    }
    
}
