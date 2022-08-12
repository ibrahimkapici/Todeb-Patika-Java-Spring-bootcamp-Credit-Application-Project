package com.example.credit.demo.model.entity;

import com.example.credit.demo.model.enums.CreditStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="approved_applications")
public class ApprovedApplications extends CreditApplication{
    @Id
    @Column(name="application_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @Transient
    private final Integer creditLimitMultiplier = 4;

    @Column(name = "credit_amount")
    private double creditAmount;

    @Column(name = "credit_score")
    private int creditScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_status")
    private CreditStatus creditStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private Customer customer;

}
