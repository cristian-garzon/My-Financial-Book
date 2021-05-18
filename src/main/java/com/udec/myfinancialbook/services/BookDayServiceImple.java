package com.udec.myfinancialbook.services;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.repository.IBookDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDayServiceImple implements IBookDayService{

    @Autowired
    private IBookDayRepo bookDayRepo;


    @Override
    public List<BookDay> listBookdays() {
        return bookDayRepo.findAll();
    }

    @Override
    public BookDay findById(Long id) {
        return bookDayRepo.findById(id).orElse(null);
    }
}
