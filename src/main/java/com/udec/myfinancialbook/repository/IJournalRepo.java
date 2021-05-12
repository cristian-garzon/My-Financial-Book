package com.udec.myfinancialbook.repository;

import com.udec.myfinancialbook.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface IJournalRepo extends JpaRepository<Journal, Date> {

}
