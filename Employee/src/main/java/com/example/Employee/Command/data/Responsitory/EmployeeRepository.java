package com.example.Employee.Command.data.Responsitory;

import com.example.Employee.Command.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    @Modifying
    @Query("delete from  Employee e  where e.Id =:id")
    void deleteEmployeeById(@Param("id") String id) ;
    @Query("select  u from  Employee  u where u.Id =: id")
    Employee getById(@Param("id") String id) ;
}
