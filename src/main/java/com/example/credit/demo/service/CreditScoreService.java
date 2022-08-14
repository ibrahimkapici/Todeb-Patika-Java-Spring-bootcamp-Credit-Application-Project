package com.example.credit.demo.service;

import com.example.credit.demo.model.entity.CreditScore;
import com.example.credit.demo.repository.CreditScoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditScoreService {
    CreditScoreRepository repository;

   public CreditScore getByIdentityNumber(String identityNumber){
       Optional<CreditScore> score = repository.findById(identityNumber);
       return score.orElse(new CreditScore());
   }
}
