package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.mayorLedge;
import com.udec.myfinancialbook.service.IMayorLedgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="https://localhost:4200")
@RequestMapping("/Mayor")
public class MayorLengeController {

    @Autowired
    private IMayorLedgeService mayorLedgeService;

    //list
    @GetMapping("/list")
    public List<mayorLedge> list(@RequestParam("id_enterprise") int id_enterprise){
        return mayorLedgeService.list(id_enterprise);
    }
}
