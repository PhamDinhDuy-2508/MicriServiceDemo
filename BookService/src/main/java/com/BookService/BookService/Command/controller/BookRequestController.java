package com.BookService.BookService.Command.controller;

import com.BookService.BookService.Command.command.AddBookCommand;
import com.BookService.BookService.Command.command.DeleteBookCommand;
import com.BookService.BookService.Command.command.UpdateBookCommand;
import com.BookService.BookService.Command.model.DeleteBookModel;
import com.BookService.BookService.Command.model.RequestBookModel;
import com.BookService.BookService.Command.model.UpdateBookModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
public class BookRequestController {
    @Autowired
    private CommandGateway commandGateway;
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody RequestBookModel requestBookModel) {

        AddBookCommand addBookCommand = new AddBookCommand(requestBookModel.getId(), requestBookModel.getAuthor(), requestBookModel.getName(), requestBookModel.isIsread());

        commandGateway.sendAndWait(addBookCommand);

        return ResponseEntity.ok("Book Was Added");
    }
    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody UpdateBookModel requestBookModel) {

        UpdateBookCommand updateBookCommand = new UpdateBookCommand(requestBookModel.getId(), requestBookModel.getAuthor(), requestBookModel.getName(), requestBookModel.isIsread());

        commandGateway.sendAndWait(updateBookCommand);

        return ResponseEntity.ok("Book Was Uppdated");
    }
    @DeleteMapping("/deleteBook")
    public ResponseEntity<?> deleteBook(@RequestBody DeleteBookModel requestBookModel) {

        DeleteBookCommand deleteBookCommand = new DeleteBookCommand(requestBookModel.getId(), requestBookModel.getAuthor(), requestBookModel.getName(), requestBookModel.isIsread());

        commandGateway.sendAndWait(deleteBookCommand);

        return ResponseEntity.ok("Book Was Deleted");
    }


}
