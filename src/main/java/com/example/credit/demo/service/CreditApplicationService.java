package com.example.credit.demo.service;

import com.example.credit.demo.model.dto.CreditApplicationDTO;
import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.CreditScore;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.mapper.CreditApplicationMapper;
import com.example.credit.demo.model.mapper.CustomerMapper;
import com.example.credit.demo.repository.CreditApplicationRepository;
import com.example.credit.demo.repository.CreditScoreRepository;
import com.example.credit.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditApplicationService {

    private final CreditApplicationRepository creditApplicationRepository;
    private final CustomerRepository customerRepository;
    private final CreditScoreRepository creditScoreRepository;



//    public CreditApplication createApplication(CreditApplicationDTO creditApplicationDTO){
//        CreditApplication creditApplication = CreditApplicationMapper.toEntity(creditApplicationDTO);
//        Customer customer = customerRepository.findById(creditApplicationDTO.getCustomer().getIdentityNumber());
//        if (customer == null){
//            throw new EntityNotFoundException("customer");
//        }
//
//        return creditApplicationRepository.save(creditApplication);
//
//    }
//    public CreditApplication createApplication(Customer customer){
//        CreditApplication creditApplication = new CreditApplication(customer);
//        return creditApplicationRepository.save(creditApplication);
//    }
    public CreditApplication getApplicationById(Long applicationId){
        Optional<CreditApplication> byId = creditApplicationRepository.findById(applicationId);
        return byId.orElseThrow(()-> new RuntimeException("Application not found"));

    }
//    public CreditApplicationService getCreditScore(CustomerDTO customerDTO){
//
//        return getCreditScore(customerDTO);
//    }

}
