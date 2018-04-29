/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.models.Book;
import java.util.ArrayList;
import java.util.List;


public class BookService {
    public static List<Book> list = new ArrayList<>();
   
    
    public BookService () {
       
    }
        
    public List<Book> getAllBooks() {
        return list;
    }

    public Book createBook(Book book){
        book.setId(list.size() + 1);
        list.add(book);
        System.err.println("size of list is " + list.size());
        System.out.println("201 -  book create with id:" + String.valueOf(book.getId()));
        return book;
    }
        
    public Book readBook(int id) {
        return list.get(id-1);
    }
     
    public Book updateBook(Book book){
        if (book.getId() <= 0) {
            return null;
        }
        list.set(book.getId()-1, book);
        System.out.println("200 -  book id:" + String.valueOf(book.getId()) + " updated");
        return book;
    }
    
    public Book deleteBook(int id){
        if (id <= 0) {
            return null;
        }
        Book b = list.get(id-1);
        list.remove(id-1);
        System.out.println("204 -  book id:" + String.valueOf(id) + " deleted");
        return b;
    }
}