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
 
    private String type;
    private int sortCode, number, currentBalance;
    private ArrayList<Transaction> transactions;
    
    
    public Account() {
        
    }

    public Account( String type, int sortCode, int number, int currentBalance) {
        transactions = new ArrayList();
        this.sortCode = sortCode;
        this.number = number;
        this.currentBalance = currentBalance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public long getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
    
    
}
