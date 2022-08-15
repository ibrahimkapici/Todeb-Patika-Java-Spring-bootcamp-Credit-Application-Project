package com.example.credit.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    private double salary;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<CreditApplication> creditApplicationsList;

// ilk çalıştığı hali
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private List<CreditApplication> creditApplicationsList = new ArrayList<>();


    public void addCreditApplication(CreditApplication creditApplication) {
        creditApplicationsList.add(creditApplication);
    }

    public Customer(Long id, String identityNumber, String name, String surname, String phoneNumber, double salary) {
        this.id = id;
        this.identityNumber = identityNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }
}
