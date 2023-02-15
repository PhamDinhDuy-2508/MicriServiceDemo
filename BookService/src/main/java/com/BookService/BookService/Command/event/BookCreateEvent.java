package com.BookService.BookService.Command.event;

public class BookCreateEvent {
    private  String Id;
    private  String Author ;
    private  String Name ;
    private  boolean Isread ;

    public BookCreateEvent(String id, String author, String name, boolean isread) {
        Id = id;
        Author = author;
        Name = name;
        Isread = isread;
    }

    public BookCreateEvent() {
    }

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
