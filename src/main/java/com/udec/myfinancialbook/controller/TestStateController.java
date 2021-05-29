package com.udec.myfinancialbook.controller;

import com.udec.myfinancialbook.model.TestState;
import com.udec.myfinancialbook.service.ITestStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/state")
public class TestStateController {

     @Autowired
     ITestStateService stateService;

     @GetMapping("/list")
     public List<TestState> list(@RequestParam("id_enterprise") int id_enterprise){
          return stateService.list(id_enterprise);
     }
}
