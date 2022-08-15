package com.example.credit.demo.controller;

import com.example.credit.demo.model.entity.OnetimeToken;
import com.example.credit.demo.service.OnetimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("onetime")
public class OnetimeController {

    @Autowired
    OnetimeService service;

    @PostMapping
    public Long onetime() {
        return service.create();
    }


    @PostMapping("auth")
    public ResponseEntity auth(@RequestBody OnetimeToken token) {
        return service.auth(token);
    }


}
