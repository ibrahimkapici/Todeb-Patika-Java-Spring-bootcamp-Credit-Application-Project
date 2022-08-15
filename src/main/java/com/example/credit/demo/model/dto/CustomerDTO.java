package com.example.credit.demo.model.dto;

import com.example.credit.demo.model.entity.CreditApplication;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String identityNumber;
    private String name;
    private String surname;
    private String phoneNumber;
    private int creditScore;
    private double salary;

    private List<CreditApplication> creditApplicationsList;

    public static final class  CustomerDTOBuilder{
        private Long id;
        private String identityNumber;
        private String name;
        private String surname;
        private String phoneNumber;
        private int creditScore;
        private double salary;

        private CustomerDTOBuilder(){

        }

        public static CustomerDTOBuilder aCustomerDTO(){
        return new CustomerDTOBuilder();
        }
        public CustomerDTO.CustomerDTOBuilder id(Long id){
            this.id = id;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder identityNumber(String identityNumber){
            this.identityNumber = identityNumber;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder name(String name){
            this.name = name;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder phoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder creditScore(int creditScore){
            this.creditScore = creditScore;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder salary(double salary){
            this.salary = salary;
            return this;
        }

        public CustomerDTO build(){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(id);
            customerDTO.id = id;
            customerDTO.setIdentityNumber(identityNumber);
            customerDTO.setName(name);
            customerDTO.setSurname(surname);
            customerDTO.setPhoneNumber(phoneNumber);
            customerDTO.setCreditScore(creditScore);
            customerDTO.setSalary(salary);
            return customerDTO;
        }
    }


}

