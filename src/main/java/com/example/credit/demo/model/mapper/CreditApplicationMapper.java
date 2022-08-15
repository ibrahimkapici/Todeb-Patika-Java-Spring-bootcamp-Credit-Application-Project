package com.example.credit.demo.model.mapper;

import com.example.credit.demo.model.dto.CreditApplicationDTO;
import com.example.credit.demo.model.entity.CreditApplication;

public class CreditApplicationMapper {
    public static CreditApplicationDTO toDTO(CreditApplication creditApplication) {
        CreditApplicationDTO creditApplicationDTO = new CreditApplicationDTO();
        creditApplicationDTO.setApplicationId(creditApplication.getApplicationId());
        creditApplicationDTO.setCreditStatus(creditApplication.getCreditStatus());
        creditApplicationDTO.setCreditAmount(creditApplication.getCreditAmount());
        creditApplicationDTO.setCreditScore(creditApplication.getCreditScore());
        return creditApplicationDTO;
    }

    public static CreditApplication toEntity(CreditApplicationDTO creditApplicationDTO) {
        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setApplicationId(creditApplicationDTO.getApplicationId());
        creditApplication.setCreditStatus(creditApplicationDTO.getCreditStatus());
        creditApplication.setCreditAmount(creditApplicationDTO.getCreditAmount());
        creditApplication.setCreditScore(creditApplicationDTO.getCreditScore());
        return creditApplication;
    }
}
