/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esu
 */

@XmlRootElement
public class Account {
 
    private long sortCode, number, currentBalance;
    private ArrayList<Transaction> transactions;
    
    
    public Account() {
        
    }

    public Account(long sortCode, long number, long currentBalance) {
        transactions = new ArrayList();
        this.sortCode = sortCode;
        this.number = number;
        this.currentBalance = currentBalance;
    }

    public long getSortCode() {
        return sortCode;
    }

    public void setSortCode(long sortCode) {
        this.sortCode = sortCode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(long currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    
}
