package com.BrrowingServices.BrrowingService.Command.data.Respository;

import com.BrrowingServices.BrrowingService.Command.data.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    @Query("select u from Borrow  u where u.id =:ID")
    Borrow findById(@Param("ID") String id);

    @Query("select  u from  Borrow  u where u.BookId =:ID")
    List<Borrow> findByBookId(@Param("ID") String id);

    @Query("select  u from  Borrow  u where u.employeeId =:ID")
    List<Borrow> findByEmployeeId(@Param("ID") String id);

}
