package com.BookService.BookService.Query.Controller;

import com.BookService.BookService.Message.SendService;
import com.BookService.BookService.Query.model.BookResponseModel;
import com.BookService.BookService.Query.queries.GetBook;
import com.BookService.BookService.Query.queries.GetallBook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.serialization.JavaSerializer;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.MessageChannel;


import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookRequestController_2  {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate ;
    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    private SendService sendService   ;


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

    @GetMapping("/sendMessage")
    public String SendMessage( String message) {
        sendService.SendMessage("phamduyasdasd");

        return "done";
    }

}
