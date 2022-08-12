package com.example.credit.demo.model.entity;


import com.example.credit.demo.model.enums.CreditStatus;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Validated
@Entity
@Data
@Table(name = "CreaditApplication")
public class CreditApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationId")
    private Long applicationId;

    @Transient
    private final Integer creditLimitMultiplier = 4;

    @Column(name = "credit_amount")
    private double creditAmount;

    @NotNull
    @Column(name = "credit_score")
    private int creditScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_status")
    private CreditStatus creditStatus;

    @NotNull(message = "Customer can not be null for credit application")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_identity_number",referencedColumnName = "identity_number")
    private Customer customer;
}
