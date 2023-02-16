package com.BrrowingServices.BrrowingService.Query.model;

import lombok.Data;

import java.util.Date;
@Data
public class BorrowReponse {
    private String id;
    private String BookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;
}
