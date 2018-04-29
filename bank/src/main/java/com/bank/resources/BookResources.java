/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.resources;

import com.bank.models.Book;
import com.bank.services.BookService;
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

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResources {
    
    BookService BookServices = new BookService();
    
    @GET
    public List<Book> getBooks() {
        return BookServices.getAllBooks();
    }    

    @GET
    @Path("/{bookId}")
    public Book getBook(@PathParam("bookId") int id) {
        return BookServices.readBook(id);
    }
    
    @POST
    public Book postBook(Book b) {       
        return BookServices.createBook(b);
    }
    
    @PUT
    @Path("/{bookId}")
    public Book putBook(@PathParam("bookId") int id, Book b) { 
        b.setId(id);
        return BookServices.updateBook(b);
    }
            
    @DELETE
    @Path("/{bookId}")
    public void deleteBook(@PathParam("bookId") int id) { 
        BookServices.deleteBook(id);
    }
      
}
