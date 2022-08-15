package com.example.credit.demo.repository;

import com.example.credit.demo.model.entity.OnetimeToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnetimeTokenRepository extends JpaRepository<OnetimeToken, Long> {
}
