package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.model.Entrerprise;
import com.udec.myfinancialbook.repository.IBookDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public List<BookDay> list(int enterprise_id) {
        List<BookDay> bookDays = bookDayRepo.findAll();
        ArrayList<BookDay> listBook = new ArrayList<>();
        for (int i = 0; i < bookDays.size(); i++){
            if(bookDays.get(i).getBusiness().getId() == enterprise_id) listBook.add(bookDays.get(i));
        }
        return listBook;
    }

    @Override
    public Optional<BookDay> find(int id) {
        return bookDayRepo.findById(id);
    }

    @Override
    public void addJournal(int code, double credit, double debit, String description, int enterprise_id) {
        BookDay bookDay = new BookDay(code,debit,credit,description, entrerpriseService.find(enterprise_id).get(), pucContableService.find(code).get());
        bookDayRepo.save(bookDay);
    }

    @Override
    public boolean update(double credit, double debit, int id) {
        if(bookDayRepo.existsById(id)){
            BookDay bookDay = new BookDay(id,find(id).get().getCode(),debit,credit, find(id).get().getDescription(),find(id).get().getDate(),find(id).get().getBusiness(),pucContableService.find(find(id).get().getCode()).get());
            bookDayRepo.save(bookDay);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(bookDayRepo.existsById(id)){
            bookDayRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean doubleCounting(int enterprise_id, String dateS) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateS);
            dateS=format.format(date);
        }catch (ParseException e){
            System.out.println("Error to parse Date");
        }
        List<BookDay> bookDays = list(enterprise_id);
        int credit = 0;
        int debit = 0;
        for (int i=0; i < bookDays.size(); i++){
            if (bookDays.get(i).getDate().toString().equals(dateS)){
               credit += bookDays.get(i).getCredit();
               debit += bookDays.get(i).getDebit();
            }
        }
        return credit == debit && credit+debit != 0;

    }


}
