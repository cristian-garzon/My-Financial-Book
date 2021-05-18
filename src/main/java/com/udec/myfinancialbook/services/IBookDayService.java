package com.udec.myfinancialbook.services;

import com.udec.myfinancialbook.model.BookDay;

import java.util.List;

public interface IBookDayService {

    List<BookDay> listBookdays();

    BookDay findById(Long id);

}
