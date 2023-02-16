package com.BrrowingServices.BrrowingService.Command.model;

import lombok.Data;

import java.util.Date;
@Data
public class BorrowCreatedModel {
    private String id;
    private String BookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;

}
