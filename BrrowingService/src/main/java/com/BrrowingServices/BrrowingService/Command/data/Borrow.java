package com.BrrowingServices.BrrowingService.Command.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "borrow")
@Data
public class Borrow {
    @Id
    private String id;
    private String BookId;
    private String employeeId;
    private Date borrowingDate;
    private Date returnDate;

}
