/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.models;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author esu
 */
@XmlRootElement
public class Transaction {
    
    private Date date;
    //type: two options: Debit or Credit
    private String type, description;
    private long newBalance;

    public Transaction() {
    }

    public Transaction(String type, String description, long newBalance) {
        this.date = new Date();
        this.type = type;
        this.description = description;
        this.newBalance = newBalance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(long newBalance) {
        this.newBalance = newBalance;
    }
    
    
    
}
