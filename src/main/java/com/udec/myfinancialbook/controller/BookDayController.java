package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.model.Entrerprise;
import com.udec.myfinancialbook.model.PucContable;
import com.udec.myfinancialbook.service.IBookDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/BookDay")
public class BookDayController {

    @Autowired
    private IBookDayService bookDayService;

    //list
    @PostMapping("/list")
    public List<BookDay> list(){
        return bookDayService.list();
    }
    //add Journal
    @PostMapping("/add")
    public void add(@RequestParam("code") int code, @RequestParam("credit") double credit, @RequestParam("debit") double debit,@RequestParam ("description") String description, @RequestParam("enterprise_id") int enterprise_id){
         bookDayService.addJournal(code,credit,debit,description,enterprise_id);

    }
}
