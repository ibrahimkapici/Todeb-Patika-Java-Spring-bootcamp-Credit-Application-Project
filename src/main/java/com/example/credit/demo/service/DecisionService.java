package com.example.credit.demo.service;

import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.CreditScore;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.enums.CreditStatus;
import org.springframework.stereotype.Service;

import static com.example.credit.demo.cons.Constants.CREDIT_MULTIPLIER;
@Service
public class DecisionService {
    //decide returns the credit application result.
    public CreditApplication decide(Customer customer, CreditScore creditScore){

        if (creditScore.getCreditScore() < 500){
            return new CreditApplication(creditScore.getCreditScore(), CreditStatus.RED );
        }
        else if (creditScore.getCreditScore() < 1000){
            if(customer.getSalary() < 5000) {
                return new CreditApplication(10_000d, creditScore.getCreditScore(), CreditStatus.ONAY);
            }
            return new CreditApplication(20_000d, creditScore.getCreditScore(), CreditStatus.ONAY);
        }
        return new CreditApplication(customer.getSalary() * CREDIT_MULTIPLIER, creditScore.getCreditScore(), CreditStatus.ONAY);
    }
}
