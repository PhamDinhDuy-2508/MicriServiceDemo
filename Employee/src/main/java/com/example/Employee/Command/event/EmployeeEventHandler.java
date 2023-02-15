package com.example.Employee.Command.event;

import com.example.Employee.Command.data.Employee;
import com.example.Employee.Command.data.Responsitory.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class EmployeeEventHandler {
    @Autowired
    EmployeeRepository employeeRepository ;


    @EventHandler
    public void handle(AddEmployeeEvent addEmployeeEvent) {
        Employee employee =  new Employee() ;
        BeanUtils.copyProperties(addEmployeeEvent , employee);
        employeeRepository.save(employee) ;
    }

    @EventHandler
    public void handle(UpdateEmployeeEvent updateEmployeeEvent) {
        Employee employee = new Employee()  ;
        BeanUtils.copyProperties(updateEmployeeEvent , employee);
        employeeRepository.save(employee) ;

    }
    @EventHandler
    @Transactional
    public void handle(DeleteEventEvent deleteEventEvent) {
        employeeRepository.deleteEmployeeById(deleteEventEvent.getId()) ;


    }



}
