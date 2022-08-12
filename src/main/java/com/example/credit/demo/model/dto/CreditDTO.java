package com.example.credit.demo.model.dto;

import com.example.credit.demo.model.enums.CreditStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditDTO {
    private CreditStatus creditStatus;
    private static double creditLimitMultiplier;
    private double creditAmount;
}
