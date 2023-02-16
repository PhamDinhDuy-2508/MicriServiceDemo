package com.BrrowingServices.BrrowingService.Query.projection;

import com.BrrowingServices.BrrowingService.Command.data.Borrow;
import com.BrrowingServices.BrrowingService.Command.data.Respository.BorrowRepository;
import com.BrrowingServices.BrrowingService.Query.model.BorrowReponse;
import com.BrrowingServices.BrrowingService.Query.queries.GetByBookId;
import com.BrrowingServices.BrrowingService.Query.queries.GetByEmployeeId;
import com.BrrowingServices.BrrowingService.Query.queries.GetById;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BorrowProjection {
    @Autowired
    BorrowRepository borrowRepository;

    @QueryHandler
    public BorrowReponse handle(GetById getById) {
        BorrowReponse borrowReponse = new BorrowReponse();
        Borrow borrow = borrowRepository.findById(getById.getId());
        BeanUtils.copyProperties(borrow, borrowReponse);
        return borrowReponse;
    }

    @QueryHandler
    public List<BorrowReponse> handle(GetByBookId get) {
        List<Borrow> borrowList =   borrowRepository.findByBookId(get.getBookId()) ;
        List<BorrowReponse> borrowReponseList =  new ArrayList<>() ;
        borrowList.parallelStream().forEach(borrow -> {
                    BorrowReponse borrowReponse =  new BorrowReponse() ;
                    BeanUtils.copyProperties(borrow , borrowReponse);
                    borrowReponseList.add(borrowReponse);
                }
        );
        return borrowReponseList ;
    }

    @QueryHandler
    public  List<BorrowReponse> handle(GetByEmployeeId get) {
        List<Borrow> borrowList =   borrowRepository.findByEmployeeId(get.getEmployeeId()) ;
        List<BorrowReponse> borrowReponseList =  new ArrayList<>() ;
        borrowList.parallelStream().forEach(borrow -> {
                    BorrowReponse borrowReponse =  new BorrowReponse() ;
                    BeanUtils.copyProperties(borrow , borrowReponse);
                    borrowReponseList.add(borrowReponse);
                }
        );
        return borrowReponseList ;
    }

}
