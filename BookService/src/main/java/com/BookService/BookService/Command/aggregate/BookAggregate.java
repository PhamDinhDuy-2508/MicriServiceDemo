package com.BookService.BookService.Command.aggregate;

import com.BookService.BookService.Command.command.AddBookCommand;
import com.BookService.BookService.Command.command.DeleteBookCommand;
import com.BookService.BookService.Command.command.UpdateBookCommand;
import com.BookService.BookService.Command.event.BookCreateEvent;
import com.BookService.BookService.Command.event.BookEventDelete;
import com.BookService.BookService.Command.event.BookUpdateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
@Aggregate
public class BookAggregate {
    @AggregateIdentifier
    private String Id;
    private String Author;
    private String Name;
    private boolean Isread;

    public BookAggregate() {
    }

    @CommandHandler
    public BookAggregate(AddBookCommand addBookCommand) {
        BookCreateEvent bookCreateEvent = new BookCreateEvent();
        BeanUtils.copyProperties(addBookCommand, bookCreateEvent);
        // su dung nhu set get
        AggregateLifecycle.apply(bookCreateEvent);
    }

    @CommandHandler
    public void handle(UpdateBookCommand updateBookCommand) {
        BookUpdateEvent bookUpdateEvent = new BookUpdateEvent();
        BeanUtils.copyProperties(updateBookCommand, bookUpdateEvent);
        AggregateLifecycle.apply(bookUpdateEvent);
    }

    @CommandHandler
    public void handle(DeleteBookCommand deleteBookCommand) {
        BookEventDelete bookEventDelete = new BookEventDelete();
        BeanUtils.copyProperties(deleteBookCommand, bookEventDelete);
        AggregateLifecycle.apply(bookEventDelete);
    }

    @EventSourcingHandler
    public void on(BookCreateEvent event) {
        this.Id = event.getId();
        this.Author = event.getAuthor();
        this.Isread = event.isIsread();
        this.Name = event.getName();
    }

    @EventSourcingHandler
    public void on(BookUpdateEvent bookUpdateEvent) {
        this.Id = bookUpdateEvent.getId();

        this.Author = bookUpdateEvent.getAuthor();
        this.Isread = bookUpdateEvent.isIsread();
        this.Name = bookUpdateEvent.getName();
    }

    @EventSourcingHandler
    public void on(BookEventDelete bookEventDelete) {
        this.Id = bookEventDelete.getId();
        this.Name = bookEventDelete.getName();
    }


}
