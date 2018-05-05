/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.models;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Customer {
    private int id;
    private String name, address, loginName, password;
    private ArrayList<Account> accounts = new ArrayList();
   
    
    public Customer(){}

    public Customer(String name){
        this.name = name;
    }
    
    public Customer(int id, String name, String address, String loginName, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.loginName = loginName;
        this.password = password;
        
    }
    
    public ArrayList<Account> getAccounts(){
        return accounts;
    }
    
    public int getNumberOfAccount(){
        return accounts.size();
    }
    
    public Account createAccount(String type){
        //create new account
        Account a = new Account(type);
        //add it to the list 
        accounts.add(a);
        
        return a;
    }
    
    public void deleteAccount(Account a){
        
        int accNum = a.getNumber();
        
        for (Account account : accounts) {
            if(account.getNumber() == accNum){
                accounts.remove(account);
            }
        }
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
