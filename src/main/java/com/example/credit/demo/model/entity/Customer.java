package com.example.credit.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;
    @Column(name = "identity_number")
    @Size(min=11,max=11,message = "National Identity Number must be 11 characters")
    private String identityNumber;
    private String name;
    private String surname;
    private String phoneNumber;
    private int creditScore;
    private double salary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<CreditApplication> creditApplicationList;


}
