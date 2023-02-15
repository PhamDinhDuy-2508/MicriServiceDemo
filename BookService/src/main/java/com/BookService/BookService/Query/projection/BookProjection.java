package com.BookService.BookService.Query.projection;

import com.BookService.BookService.Command.data.Book;
import com.BookService.BookService.Command.data.Respository.BookRespository;
import com.BookService.BookService.Query.model.BookResponseModel;
import com.BookService.BookService.Query.queries.GetBook;
import com.BookService.BookService.Query.queries.GetallBook;
import org.axonframework.queryhandling.QueryHandler;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookProjection {
    @Autowired
    BookRespository bookRespository;

    @QueryHandler
    public BookResponseModel handle(GetBook getBook) {
        BookResponseModel bookResponseModel = new BookResponseModel();
        Book book = bookRespository.getBookById(String.valueOf(getBook.getId()));
        BeanUtils.copyProperties(book, bookResponseModel);
        return bookResponseModel;
    }

    @QueryHandler
    public List<BookResponseModel> handle(GetallBook getallBook) {
        List<BookResponseModel> bookList = new ArrayList<>();
        List<Book> entity = bookRespository.findAll();
        for (Book x : entity) {
            BookResponseModel model = new BookResponseModel();
            BeanUtils.copyProperties(x, model);
            bookList.add(model);
        }
        return bookList ;
    }

}
