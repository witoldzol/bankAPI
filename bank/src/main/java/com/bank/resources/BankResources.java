/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Customer;
import com.bank.services.BankServices;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/banking")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BankResources {
    
    BankServices bs = new BankServices();
    
    
    @GET
    public List<Customer> getAllCustomers(){
        return bs.getAllCustomers();
    }
    
    
    @POST
    public Customer createCustomer(Customer c) {       
        
        bs.createCustomer(c);
        
        return c;
        
    }
    
      
}
