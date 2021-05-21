package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.PucContable;
import com.udec.myfinancialbook.service.IPucContableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="https://localhost:4200")
@RequestMapping("/puc")
public class PuContableController {

    @Autowired
    private IPucContableService pucContableService;

    @GetMapping("/list")
    public List<PucContable> list(){
        return pucContableService.list();
    }

    @GetMapping("/find")
    public Optional<PucContable> find(@RequestParam("code") int code){
        return pucContableService.find(code);
    }
}
