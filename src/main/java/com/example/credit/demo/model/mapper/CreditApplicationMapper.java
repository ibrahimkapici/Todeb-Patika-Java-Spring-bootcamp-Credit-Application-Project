package com.example.credit.demo.model.mapper;

import com.example.credit.demo.model.dto.CreditApplicationDTO;
import com.example.credit.demo.model.dto.CreditDTO;
import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.Customer;

public class CreditApplicationMapper {
    public static CreditApplicationDTO toDTO(CreditApplication creditApplication) {
        CreditApplicationDTO creditApplicationDTO = new CreditApplicationDTO();
        creditApplicationDTO.setApplicationId(creditApplication.getApplicationId());
        creditApplicationDTO.setCreditStatus(creditApplication.getCreditStatus());
        creditApplicationDTO.setCreditAmount(creditApplication.getCreditAmount());
        creditApplicationDTO.setCustomer(creditApplication.getCustomer());
        creditApplicationDTO.setCreditScore(creditApplication.getCreditScore());
        return creditApplicationDTO;
    }

    public static CreditApplication toEntity(CreditApplicationDTO creditApplicationDTO) {
        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setApplicationId(creditApplicationDTO.getApplicationId());
        creditApplication.setCreditStatus(creditApplicationDTO.getCreditStatus());
        creditApplication.setCreditAmount(creditApplicationDTO.getCreditAmount());
        creditApplication.setCustomer(creditApplicationDTO.getCustomer());
        creditApplication.setCreditScore(creditApplicationDTO.getCreditScore());
        return creditApplication;
    }
}
