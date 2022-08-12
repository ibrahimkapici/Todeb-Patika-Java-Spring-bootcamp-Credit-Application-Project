package com.example.credit.demo.repository;

import com.example.credit.demo.model.entity.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<CreditApplication, Long> {

}
