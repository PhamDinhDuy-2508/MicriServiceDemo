package com.BookService.BookService.Command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteBookCommand {
    @TargetAggregateIdentifier
    private  String Id;/// ID nay khog duoc lon hon 2000 neu lon hon 200 se bi loi out oof range
    private  String Author ;
    private  String Name ;
    private  boolean Isread ;

    public DeleteBookCommand(String id, String author, String name, boolean isread) {
        Id = id;
        Author = author;
        Name = name;
        Isread = isread;
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
