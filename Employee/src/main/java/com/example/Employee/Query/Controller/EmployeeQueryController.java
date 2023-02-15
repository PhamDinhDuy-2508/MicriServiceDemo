package com.example.Employee.Query.Controller;

import com.example.Employee.Command.data.Employee;
import com.example.Employee.Query.model.EmployeeReponseModel;
import com.example.Employee.Query.queries.GetById;
import com.example.Employee.Query.queries.Getall;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeQueryController {
    @Autowired
    QueryGateway queryGateway;

    @GetMapping("/Employee/get/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable String id) {
        GetById get = new GetById();
        get.setId(id);
        EmployeeReponseModel employee = queryGateway.query(get, ResponseTypes.instanceOf(EmployeeReponseModel.class)).join();
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/Employee/getAll")
    public  ResponseEntity<?> getAll()  {
        Getall getall =  new Getall() ;
        List<EmployeeReponseModel> employeeResponseModel =  queryGateway.query( getall,  ResponseTypes.multipleInstancesOf(EmployeeReponseModel.class)).join()  ;
        return  ResponseEntity.ok(employeeResponseModel) ;

    }
}
