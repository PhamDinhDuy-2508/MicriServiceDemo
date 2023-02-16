package com.BrrowingServices.BrrowingService.Command.controller;

import com.BrrowingServices.BrrowingService.Command.command.BorroqwDeletedCommand;
import com.BrrowingServices.BrrowingService.Command.command.BorrowCreatedCommand;
import com.BrrowingServices.BrrowingService.Command.model.BorrowCreatedModel;
import com.BrrowingServices.BrrowingService.Command.model.BorrowDeleteModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Borrow")
public class BorrowRestController {

    @Autowired
    private CommandGateway commandGateway ;

    @PostMapping("/borrow")
    public void BorrowCreated(@RequestBody BorrowCreatedModel borrowCreatedModel) {
        BorrowCreatedCommand borrowCreatedCommand =  new BorrowCreatedCommand() ;
        BeanUtils.copyProperties(borrowCreatedModel ,  borrowCreatedCommand);
        commandGateway.sendAndWait(borrowCreatedCommand) ;
    }

    @DeleteMapping("/DeleteBorrow")
    public void BorrowDeleted(@RequestBody BorrowDeleteModel borrowDeleteModel) {
        BorroqwDeletedCommand borroqwDeletedCommand   =  new BorroqwDeletedCommand() ;
        BeanUtils.copyProperties(borroqwDeletedCommand ,  borrowDeleteModel);
        commandGateway.sendAndWait(borroqwDeletedCommand) ;
    }



}
