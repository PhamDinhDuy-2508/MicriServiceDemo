package com.BookService.BookService.Command.event;

import com.BookService.BookService.Command.data.Book;
import com.BookService.BookService.Command.data.Respository.BookRespository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class BookEventHandler {
    @Autowired
    private BookRespository bookRespository;

    @EventHandler
    @Transactional
    public void on(BookCreateEvent bookCreateEvent) {
        Book book = new Book();
        BeanUtils.copyProperties(bookCreateEvent, book);
        bookRespository.save(book);
    }

    @EventHandler
    @Transactional
    public  void on (BookEventDelete bookEventDelete) {
        Book book =  new Book() ;
        BeanUtils.copyProperties(book ,  book);
        bookRespository.delete(book);
    }

    @EventHandler
    @Transactional
    public void on (BookUpdateEvent bookUpdateEvent) {
        Book book =  new Book() ;
        BeanUtils.copyProperties(bookUpdateEvent ,  book);
        bookRespository.updateInfoById(book.getName() , book.getAuthor() , bookUpdateEvent.getId());
    }
}
