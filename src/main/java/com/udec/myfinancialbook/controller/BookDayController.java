package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.BookDay;
import com.udec.myfinancialbook.services.BookDayServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookDayController {

    @Autowired
    private BookDayServiceImple bookDayServiceImple;

    //Listar todos los libros
    @GetMapping("/bookdays")
    public List<BookDay> getAllBookDay(){
        return bookDayServiceImple.listBookdays();
    }

    //Listar un libro en especifico
    @GetMapping("/bookdays/{id}")
    public BookDay showOneBookDay(@PathVariable Long id){
        BookDay newBook = bookDayServiceImple.findById(id);
        if(newBook == null){
            return null;
        }
        return newBook;
    }

}
