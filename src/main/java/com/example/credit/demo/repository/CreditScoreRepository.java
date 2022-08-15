package com.example.credit.demo.repository;

import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CreditScoreRepository extends CrudRepository<CreditScore, String> {
    CreditScore findByIdentityNumber(String identityNumber);
}
