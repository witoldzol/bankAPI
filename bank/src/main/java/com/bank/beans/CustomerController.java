/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.beans;
import com.bank.database.Customers;
import com.bank.database.CustomersFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author strug
 */
@Named(value="customerController")
@SessionScoped
public class CustomerController implements Serializable {
    
    @EJB
    CustomersFacade customerFacade;
    
    @Inject
    CustomerBean customerBean;
    
    public List<Customers> getAllCust(){
        return customerFacade.findAll();
    }
    
    public int countCust(){
        return customerFacade.count();
    }
    
    public String deleteCust(Customers c){
        customerFacade.remove(c);
        return null;
    }
    
    public String addCust() {
        
        Customers c = new Customers();
        
        c.setName(customerBean.getName());
        c.setAddress(customerBean.getAddress());
        c.setLoginName(customerBean.getLoginName());
        c.setPassword(customerBean.getPassword());
        
        customerFacade.create(c);
        
        return "index";
    }
    
    public String editCust(Customers c) {
        
        customerBean.setName(c.getName());
        customerBean.setAddress(c.getAddress());
        customerBean.setLoginName(c.getLoginName());
        customerBean.setPassword(c.getPassword());
        
        return "update";
    }
    
    public String saveCust() {
        Customers c = new Customers(customerBean.getId());
        c.setName(customerBean.getName());
        c.setAddress(customerBean.getAddress());
        c.setLoginName(customerBean.getLoginName());
        c.setPassword(customerBean.getPassword());
        
        customerFacade.edit(c);
        
        return "index";
    }
}
