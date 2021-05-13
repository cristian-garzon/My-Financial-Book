package com.udec.myfinancialbook.repository;

import com.udec.myfinancialbook.model.BookDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookDayRepo extends JpaRepository<BookDay, Integer> {

}
