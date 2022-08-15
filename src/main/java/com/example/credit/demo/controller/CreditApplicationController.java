package com.example.credit.demo.controller;

import com.example.credit.demo.model.dto.CreditApplicationDTO;
import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.CreditScore;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.mapper.CustomerMapper;
import com.example.credit.demo.service.CreditApplicationService;
import com.example.credit.demo.service.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class CreditApplicationController {
    @Autowired
    CreditApplicationService creditApplicationService;
    DecisionService decisionService;

//    @PostMapping("")
//    public CreditApplication apply(@RequestBody Customer customer){
//
//        return creditApplicationService.createApplication(customer);
//    }

    @GetMapping("/result?identityNumber={}")
    public CreditApplication result(Customer customer, CreditScore creditScore){
        return decisionService.decide(customer, creditScore);
    }
}
