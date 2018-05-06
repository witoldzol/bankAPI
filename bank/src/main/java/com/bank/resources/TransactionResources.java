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

/**
 *
 * @author witold
 */

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResources {
    
    //instantiate customer services
    TransactionServices ts = new TransactionServices();
    //instantiate account services
    AccountServices as = new AccountServices();
    
    //retreives single transaction that matches specified amount for given account
    @GET
    @Path("/{amount}")
    public Transaction getTransaction(@PathParam("id") int id,
            @PathParam("accountNumber") int accountNumber,
            @PathParam("amount") double amount) {
        ArrayList al = as.getAllAccounts(id);
        Account a = as.getAccount(al, accountNumber);
        Transaction t = ts.getTransaction(a, amount);
        return t;
    }
    
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
            @PathParam("amount") double amount) 
    {
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
    
    //lodge funds to account
    @GET
    @Path("/lodge/{amount}")
    public Transaction lodgeToAccount(@PathParam("id") int id,
            @PathParam("accountNumber") int accountNumber,
            @PathParam("amount") double amount) 
    {
        String type = "Debit";
        String description = "Lodged to account";
        double newBalance;
        //get all accounts for given usr id
        ArrayList<Account> al = as.getAllAccounts(id);
        //get matching account
        Account a = as.getAccount(al, accountNumber);
        //calculate new balance
        newBalance = a.getCurrentBalance() + amount;
        //set new balance
        a.setCurrentBalance(newBalance);
        //create transaction
        Transaction tra = new Transaction(type, amount, description, newBalance);
        //record transaction
        ts.createTransaction(a, tra);

        return tra;
    }
    //transfer funds between accounts
    //creates two transactions (for both accounts)
    @POST
    @Path("/{amount}")
    public Transaction transferBetweenAccounts(@PathParam("id") int id,
            @PathParam("accountNumber") int accountNumber,
            @PathParam("amount") double amount,
            Account destinationAccount) 
    {
        // origin account -- from we send money
        String type = "Credit";
        String description = "Transferred to account " + destinationAccount.getNumber();
        double newBalance;
        //get all accounts for given usr id
        ArrayList<Account> al = as.getAllAccounts(id);
        //get matching account
        Account a = as.getAccount(al, accountNumber);
        //get all accounts in database
        ArrayList<Account> allAccounts = as.getAccountsAllUsers();
        //find destination account
        Account destination = as.getAccount(allAccounts, destinationAccount.getNumber());
        System.out.println("Destination account object" + destination);
        //check if destination account exists
        if(destination == null){
            System.out.println("Destination account doesn't exist");
            return null;
        }
        //check if we have enough funds on the account
        if ((a.getCurrentBalance() - amount) < 0) {
            System.out.println("Insufficient funds");
            return null;
        }
        //calculate new balance for origin
        newBalance = a.getCurrentBalance() - amount;
        //set new balance
        a.setCurrentBalance(newBalance);
        //create transaction
        Transaction tra = new Transaction(type, amount, description, newBalance);
        //record transaction
        ts.createTransaction(a, tra);
        // destination account 
        type = "Debit";
        description = "Transfer from account " + accountNumber;
        //set new balance for destination acc
        newBalance = destination.getCurrentBalance() + amount;
        destination.setCurrentBalance(newBalance);
        //create transaction
        Transaction destinationTra = new Transaction(type, amount, description, newBalance);
        ts.createTransaction(destination, destinationTra);
        
        return tra;
    }
}
