package com.BrrowingServices.BrrowingService.Command.event;

import com.BrrowingServices.BrrowingService.Command.data.Borrow;
import com.BrrowingServices.BrrowingService.Command.data.Respository.BorrowRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class BorrowEventHandle {
    @Autowired
    BorrowRepository borrowRepository ;

    @EventHandler
    @Transactional
    public void CreateBorrowRequest(BorrowCreatedEvent borrowCreatedEvent) {
        Borrow borrow =  new Borrow() ;
        BeanUtils.copyProperties(borrowCreatedEvent ,  borrow);
        borrowRepository.save(borrow) ;
    }

    @EventHandler
    @Transactional
    public void DeleteBorrowRequest(BorrowEventDelete borrowEventDelete) {
        Borrow borrow =  borrowRepository.findById(borrowEventDelete.getId()) ;
        BeanUtils.copyProperties(borrowEventDelete , borrow);
        borrowRepository.delete(borrow);
    }
}
