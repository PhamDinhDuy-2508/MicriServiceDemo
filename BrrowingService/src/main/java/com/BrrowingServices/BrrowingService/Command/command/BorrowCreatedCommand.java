package com.BrrowingServices.BrrowingService.Command.command;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;
@Data
public class BorrowCreatedCommand {
    @TargetAggregateIdentifier
    private String id;
    private String BookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;

}
