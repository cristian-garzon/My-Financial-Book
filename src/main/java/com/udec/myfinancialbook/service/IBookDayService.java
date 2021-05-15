package com.udec.myfinancialbook.service;

import com.udec.myfinancialbook.model.BookDay;

import java.util.List;
import java.util.Optional;

public interface IBookDayService {
    public List<BookDay> list();
    public Optional<BookDay> find(int id);
    public void  addJournal(int code, double credit, double debit, String description, int enterprise_id);
    public boolean update(double credit, double debit, int id);
    public boolean delete(int id);
}
