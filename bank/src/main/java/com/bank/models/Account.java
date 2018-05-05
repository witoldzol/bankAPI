/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.models;

import java.util.ArrayList;
import java.util.Random;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esu
 */

@XmlRootElement
public class Account {
 
    private String type;  
    private int sortCode, number, currentBalance;
    private ArrayList<Transaction> transactions = new ArrayList();
    
    
    Random rand = new Random();
    
    public Account() {}
    
    public Account( String type ) {
        this.type = type;
        this.sortCode = generateSortCode();
        this.number = generateAccountNumber();
        this.currentBalance = 0;
    }

    private int generateSortCode(){
        return rand.nextInt(888) + 111;
    }
    
    private int generateAccountNumber() {
        return rand.nextInt(888888) + 111111;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    
    
    
}
