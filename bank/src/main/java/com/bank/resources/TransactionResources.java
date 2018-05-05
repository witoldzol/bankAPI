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
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
    //withdraw funds
    @GET
    @Path("/withdraw/{amount}")
    public Transaction withdrawFromAccount(@PathParam("id") int id,
            @PathParam("accountNumber") int accountNumber,
            @PathParam("amount") double amount,
            Transaction t) {
        String type = "Credit";
        String description = "Withdraw from account";
        double newBalance;
        //get all accounts for given usr id
        ArrayList<Account> al = as.getAllAccounts(id);
        //get matching account
        Account a = as.getAccount(al, accountNumber);
        //check if we have enough funds on the account
        if( (a.getCurrentBalance() - amount) < 0){
            System.out.println("Insufficient funds");
            return null;
        }
        //calculate new balance
        newBalance = a.getCurrentBalance() - amount;
        //set new balance
        a.setCurrentBalance(newBalance);
        //create transaction
        Transaction tra = new Transaction(type, amount, description, newBalance);
        //record transaction
        ts.createTransaction(a, tra);
        
        return tra;
    }
    
    
}
