package com.BrrowingServices.BrrowingService.Query.controller;

import com.BrrowingServices.BrrowingService.Query.model.BorrowReponse;
import com.BrrowingServices.BrrowingService.Query.queries.GetByBookId;
import com.BrrowingServices.BrrowingService.Query.queries.GetByEmployeeId;
import com.BrrowingServices.BrrowingService.Query.queries.GetById;
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
@RequestMapping("/api/v1/Borrow")
public class BorrowQueryRestController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        GetById get = new GetById();
        BorrowReponse borrowReponse = queryGateway.query(get, ResponseTypes.instanceOf(BorrowReponse.class)).join();
        return ResponseEntity.ok(borrowReponse);
    }

    @GetMapping("/getByBookId/{id}")
    public ResponseEntity<?> getByBookId(@PathVariable String id) {
        GetByBookId get = new GetByBookId();
        List<BorrowReponse> borrowReponseList = queryGateway.query(get, ResponseTypes.multipleInstancesOf(BorrowReponse.class)).join();
        return ResponseEntity.ok(borrowReponseList);
    }

    @GetMapping("/getByEmployeeId/{id}")
    public ResponseEntity<?> getByEmployeeId(@PathVariable String id) {
        GetByEmployeeId get = new GetByEmployeeId();
        List<BorrowReponse> borrowReponseList = queryGateway.query(get, ResponseTypes.multipleInstancesOf(BorrowReponse.class)).join();
        return ResponseEntity.ok(borrowReponseList);
    }


}
