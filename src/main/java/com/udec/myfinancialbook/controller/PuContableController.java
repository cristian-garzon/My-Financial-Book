package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.PucContable;
import com.udec.myfinancialbook.service.IPucContableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/puc")
public class PuContableController {

    @Autowired
    private IPucContableService pucContableService;

    @PostMapping("/list")
    public List<PucContable> list(){
        return pucContableService.list();
    }

    @PostMapping("/find")
    public Optional<PucContable> find(@RequestParam("code") int code){
        return pucContableService.find(code);
    }
}
