/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Customer;
import com.bank.services.CustomerServices;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResources {
    
    //instantiate customer services
    CustomerServices cs = new CustomerServices();
    
    //get single customer
    @GET
    @Path("/{id}")
    public Customer getCustomer(@PathParam("id") int id){
        return cs.getCustomer(id);
    }
    //get all customers
    @GET
    public ArrayList<Customer> getAllCustomers(){
        return cs.getAllCustomers();
    }
    //create customer
    @POST
    public Customer createCustomer(Customer c) {       
        cs.createCustomer(c);
        return c;
    }
    //update customer
    @PUT
    @Path("/{id}")
    public Customer updateCustomer(@PathParam("id") int id, Customer c){
        return cs.updateCustomer(id, c);
    }
    //delete customer
    @DELETE
    @Path("/{id}")
    public Customer removeCustomer(@PathParam("id") int id){        
        return cs.removeCustomer(id);        
    }
    //---------------------   Path to ACCOUNTS sub rescource
    @Path("/{id}/accounts")
    public AccountResources getResources(){
        return new AccountResources();
    }
    

}
