package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.mayorLedge;
import com.udec.myfinancialbook.service.IMayorLedgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Mayor")
public class MayorLengeController {

    @Autowired
    private IMayorLedgeService mayorLedgeService;

    //list
    @PostMapping("/list")
    public List<mayorLedge> list(){
        return mayorLedgeService.list();
    }
}
