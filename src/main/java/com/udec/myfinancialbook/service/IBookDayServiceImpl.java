package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.model.Entrerprise;
import com.udec.myfinancialbook.repository.IBookDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IBookDayServiceImpl implements IBookDayService{

    @Autowired
    private IBookDayRepo bookDayRepo;

    @Autowired
    private IEntrerpriseService entrerpriseService;

    @Autowired
    private IPucContableService pucContableService;
    @Override
    public List<BookDay> list() {
        return bookDayRepo.findAll();
    }

    @Override
    public void addJournal(int code, double credit, double debit, String description, int enterprise_id) {
        BookDay bookDay = new BookDay(code,debit,credit,description, entrerpriseService.find(enterprise_id).get(), pucContableService.find(code).get());
        bookDayRepo.save(bookDay);
    }


}
