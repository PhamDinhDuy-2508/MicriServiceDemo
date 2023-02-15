package com.BookService.BookService.Query.Controller;

import com.BookService.BookService.Query.model.BookResponseModel;
import com.BookService.BookService.Query.queries.GetBook;
import com.BookService.BookService.Query.queries.GetallBook;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRequestController_2 {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/getBook/{Id}")
    public ResponseEntity<?> getBook(@PathVariable String Id) {
        GetBook getBook = new GetBook();

        getBook.setId(Long.valueOf(Id));

        BookResponseModel bookResponseModel = queryGateway.query(getBook, ResponseTypes.instanceOf(BookResponseModel.class)).join();

        return ResponseEntity.ok(bookResponseModel);
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<?> getAllBook() {

        GetallBook getallBook = new GetallBook();

        List<BookResponseModel> bookResponseModels = queryGateway.query(getallBook, ResponseTypes.multipleInstancesOf(BookResponseModel.class)).join();

        return ResponseEntity.ok(bookResponseModels);
    }

}
