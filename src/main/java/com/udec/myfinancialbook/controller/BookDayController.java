package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.model.Entrerprise;
import com.udec.myfinancialbook.model.PucContable;
import com.udec.myfinancialbook.service.IBookDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="https://localhost:4200")
@RequestMapping("/BookDay")
public class BookDayController {

    @Autowired
    private IBookDayService bookDayService;

    //list
    @GetMapping("/list")
    public List<BookDay> list(@RequestParam("enterprise_id") int enterprise_id){
        return bookDayService.list(enterprise_id);
    }
    //add Journal
    @GetMapping("/add")
    public void add(@RequestParam("code") int code, @RequestParam("credit") double credit, @RequestParam("debit") double debit,@RequestParam ("description") String description, @RequestParam("enterprise_id") int enterprise_id){
         bookDayService.addJournal(code,credit,debit,description,enterprise_id);
    }

    //update journal
    @GetMapping("/update")
    public boolean update(@RequestParam("credit") double credit, @RequestParam("debit") double debit, @RequestParam("id") int id){
        return bookDayService.update(credit, debit, id);
    }

    //delete user
    @GetMapping("/delete")
    public boolean delete(@RequestParam("id") int id){
        return bookDayService.delete(id);
    }

    //boolean for know if the Journal have double-counting
    //the date must be in the next format= yyyy-MM-dd
    @GetMapping("/doubleCounting")
    public boolean doubleCounting(@RequestParam("enterprise_id") int enterprise_id ,@RequestParam("date")  String date){
        return bookDayService.doubleCounting(enterprise_id,date);
    }
}
