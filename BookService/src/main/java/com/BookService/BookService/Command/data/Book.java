package com.BookService.BookService.Command.data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private  String Id;
    private  String Author ;
    private  String Name ;
    private  boolean Isread ;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isIsread() {
        return Isread;
    }

    public void setIsread(boolean isread) {
        Isread = isread;
    }
}
