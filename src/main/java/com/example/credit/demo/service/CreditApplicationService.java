package com.example.credit.demo.service;

import com.example.credit.demo.model.dto.CreditApplicationDTO;
import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.mapper.CreditApplicationMapper;
import com.example.credit.demo.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;


    public CreditApplication createApplication(CreditApplicationDTO creditApplicationDTO){
        CreditApplication creditApplication = CreditApplicationMapper.toEntity(creditApplicationDTO);
        return creditRepository.save(creditApplication);

    }

    public CreditApplication getApplicationById(Long applicationId){
        Optional<CreditApplication> byId = creditRepository.findById(applicationId);
        return byId.orElseThrow(()-> new RuntimeException("Application not found"));

    }
    public CreditService getCreditScore(CustomerDTO customerDTO){

        return getCreditScore(customerDTO);
    }

}
