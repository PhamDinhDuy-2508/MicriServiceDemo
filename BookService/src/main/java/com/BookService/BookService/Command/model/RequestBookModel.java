package com.BookService.BookService.Command.model;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RequestBookModel {
    private String id;
    private String author;
    private String name;
    private boolean isread;

    public RequestBookModel(String id, String author, String name, boolean isread) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.isread = isread;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
    }
}



