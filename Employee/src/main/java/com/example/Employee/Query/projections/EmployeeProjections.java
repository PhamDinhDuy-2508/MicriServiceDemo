package com.example.Employee.Query.projections;

import com.example.Employee.Command.data.Employee;
import com.example.Employee.Command.data.Responsitory.EmployeeRepository;
import com.example.Employee.Query.model.EmployeeReponseModel;
import com.example.Employee.Query.queries.GetById;
import com.example.Employee.Query.queries.Getall;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjections {
    @Autowired
    EmployeeRepository employeeRepository;

    @QueryHandler
    public EmployeeReponseModel getById(GetById get) {
        EmployeeReponseModel employeeReponseModel = new EmployeeReponseModel();
        Employee employee = employeeRepository.getById(get.getId());
        BeanUtils.copyProperties(employee, employeeReponseModel);
        return employeeReponseModel;
    }

    @QueryHandler
    public List<EmployeeReponseModel> getAll(Getall getall) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employeeRepository.findAll();
        List<EmployeeReponseModel> employeeReponseModels = new ArrayList<>();
        final EmployeeReponseModel employeeReponseModel = new EmployeeReponseModel();
        for (Employee employee : employeeList) {
            BeanUtils.copyProperties(employee, employeeReponseModel);
            employeeReponseModels.add(employeeReponseModel);
        }
        return employeeReponseModels;
    }

}
