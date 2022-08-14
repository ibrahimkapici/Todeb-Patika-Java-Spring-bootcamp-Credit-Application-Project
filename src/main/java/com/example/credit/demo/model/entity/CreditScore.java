package com.example.credit.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Table
@Entity
public class CreditScore {

    @Id
    @Size(min=11,max=11,message = "National Identity Number must be 11 characters")
    private String identityNumber;
    private int creditScore;
}
