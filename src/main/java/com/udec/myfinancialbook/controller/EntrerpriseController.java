package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.Entrerprise;
import com.udec.myfinancialbook.service.IEntrerpriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/enterprise")
public class EntrerpriseController {

    @Autowired
    private IEntrerpriseServiceImpl entrerpriseService;

    //list enterprises
    @GetMapping("list")
    public List<Entrerprise> list(){
        return entrerpriseService.list();
    }

    //find enterprises
    @GetMapping("/find")
    public Optional<Entrerprise> find(@RequestParam("id") int id){
        return entrerpriseService.find(id);
    }

    //add enterprise
    @GetMapping("/add")
    public void add(@RequestParam("nit") long nit , @RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("direction") String direction, @RequestParam("phoneNumber") String phoneNumber){
        entrerpriseService.addEntrerprise(nit, name, direction,description, phoneNumber);
    }
    // update enterprise
    @GetMapping("/update")
    public boolean update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("direction") String direction, @RequestParam("description") String description, @RequestParam("phoneNumber") String phoneNumber){
        return entrerpriseService.update(id, direction, name, description, phoneNumber);
    }

}
