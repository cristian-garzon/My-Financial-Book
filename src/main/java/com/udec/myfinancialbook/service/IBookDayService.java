package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.BookDay;

import java.util.List;

public interface IBookDayService {
    public List<BookDay> list();
    public void  addJournal(int code, double credit, double debit, String description, int enterprise_id);
}
