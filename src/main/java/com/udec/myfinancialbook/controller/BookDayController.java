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
    public List<BookDay> list(@RequestParam("enterprise_id") int enterprise_id){
        return bookDayService.list(enterprise_id);
    }
    //add Journal
    @PostMapping("/add")
    public void add(@RequestParam("code") int code, @RequestParam("credit") double credit, @RequestParam("debit") double debit,@RequestParam ("description") String description, @RequestParam("enterprise_id") int enterprise_id){
         bookDayService.addJournal(code,credit,debit,description,enterprise_id);
    }

    //update journal
    @PostMapping("/update")
    public boolean update(@RequestParam("credit") double credit, @RequestParam("debit") double debit, @RequestParam("id") int id){
        return bookDayService.update(credit, debit, id);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam("id") int id){
        return bookDayService.delete(id);
    }
}
