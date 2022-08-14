package com.example.credit.demo.model.entity;


import com.example.credit.demo.model.enums.CreditStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity
@Data
@Table(name = "CreaditApplication")
public class CreditApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicationId")
    private Long applicationId;

    @Column(name = "credit_amount")
    private double creditAmount;

    @NotNull
    @Column(name = "credit_score")
    private int creditScore;

    @Enumerated(EnumType.STRING)
    @Column(name = "credit_status")
    private CreditStatus creditStatus;

    public CreditApplication(double creditAmount, int creditScore, CreditStatus creditStatus) {
        this.creditAmount = creditAmount;
        this.creditScore = creditScore;
        this.creditStatus = creditStatus;
    }

    public CreditApplication(int creditScore, CreditStatus creditStatus) {
        this.creditScore = creditScore;
        this.creditStatus = creditStatus;
    }
}
