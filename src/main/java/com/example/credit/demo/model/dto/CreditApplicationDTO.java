package com.example.credit.demo.model.dto;

import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.enums.CreditStatus;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreditApplicationDTO {

    private Long applicationId;

    private double creditAmount;

    private int creditScore;

    private CreditStatus creditStatus;
    private Customer customer;

}
