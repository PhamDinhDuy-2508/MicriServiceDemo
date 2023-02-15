package com.example.Employee.Command.aggregate;

import com.example.Employee.Command.command.DeleteCommand;
import com.example.Employee.Command.command.EmployeeAddCommand;
import com.example.Employee.Command.command.EmployeeUpdateCommand;
import com.example.Employee.Command.event.AddEmployeeEvent;
import com.example.Employee.Command.event.DeleteEventEvent;
import com.example.Employee.Command.event.UpdateEmployeeEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.hibernate.event.spi.DeleteEvent;
import org.springframework.beans.BeanUtils;
@Aggregate
public class EmployeeAggregate {
    @AggregateIdentifier
    private String Id;

    private String username;
    private String firstname;
    private String lastname;
    private String kin;
    private Boolean isDiscipline;

    public EmployeeAggregate() {
    }

    @CommandHandler
    public EmployeeAggregate(EmployeeAddCommand employeeAddCommand) {
        AddEmployeeEvent event =  new AddEmployeeEvent() ;
        BeanUtils.copyProperties(employeeAddCommand , event);
        AggregateLifecycle.apply(event) ;
    }
    @CommandHandler
    public void handle(EmployeeUpdateCommand employeeUpdateCommand) {

        UpdateEmployeeEvent updateEmployeeEvent = new UpdateEmployeeEvent() ;
        BeanUtils.copyProperties(employeeUpdateCommand , updateEmployeeEvent);
        AggregateLifecycle.apply(updateEmployeeEvent) ;
    }

    @CommandHandler
    public void handle(DeleteCommand deleteCommand) {
            DeleteEventEvent deleteEvent = new DeleteEventEvent(deleteCommand.getId()) ;
            AggregateLifecycle.apply(deleteEvent) ;
    }

    @EventSourcingHandler
    public void on(AddEmployeeEvent event) {
        this.Id  =  event.getId() ;
        this.firstname  = event.getFirstname() ;
        this.lastname  = event.getLastname() ;
        this.kin =  event.getKin() ;
        this.isDiscipline =  event.getIsDiscipline();
    }

    @EventSourcingHandler
    public void  on (UpdateEmployeeEvent event) {
        this.Id  =  event.getId() ;
        this.firstname  = event.getFirstname() ;
        this.lastname  = event.getLastname() ;
        this.kin =  event.getKin() ;
    }
    @EventSourcingHandler
    public  void on (DeleteEventEvent deleteEvent) {
        this.Id = deleteEvent.getId();
    }

}
