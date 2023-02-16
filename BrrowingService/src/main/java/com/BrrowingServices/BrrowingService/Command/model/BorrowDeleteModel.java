package com.BrrowingServices.BrrowingService.Command.model;

import lombok.Data;

@Data
public class BorrowDeleteModel {
    private String id;
    private String BookId;
    private String employeeId;
}
