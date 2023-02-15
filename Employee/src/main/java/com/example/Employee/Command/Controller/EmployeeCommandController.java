package com.example.Employee.Command.Controller;

import com.example.Employee.Command.command.DeleteCommand;
import com.example.Employee.Command.command.EmployeeAddCommand;
import com.example.Employee.Command.command.EmployeeUpdateCommand;
import com.example.Employee.Command.model.EmployeeModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeCommandController {
    @Autowired
    CommandGateway commandGateway;

    @PostMapping("/Employee/add")
    public void AddBook(@RequestBody EmployeeModel employeeAddModel) {
        EmployeeAddCommand employeeAddCommand = new EmployeeAddCommand();
        BeanUtils.copyProperties(employeeAddModel, employeeAddCommand);
        commandGateway.sendAndWait(employeeAddCommand);
    }

    @PutMapping("/Employee/update")
    public void UpdateBook(@RequestBody EmployeeModel employeeModel) {

        EmployeeUpdateCommand employeeUpdateCommand = new EmployeeUpdateCommand();

        BeanUtils.copyProperties(employeeModel, employeeUpdateCommand);

        this.commandGateway.sendAndWait(employeeUpdateCommand);
    }

    @DeleteMapping("/Employee/Delete/{id}")
    public void Delete(@PathVariable String id) {
        DeleteCommand deleteCommand =  new DeleteCommand(id) ;

        this.commandGateway.sendAndWait(deleteCommand) ;

    }


}
