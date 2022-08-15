package com.example.credit.demo.model.mapper;

import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setIdentityNumber(customer.getIdentityNumber());
        customerDTO.setId(customer.getId());
        customerDTO.setSalary(customer.getSalary());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setCreditApplicationsList(customer.getCreditApplicationsList());

        return customerDTO;
    }

    public static Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setSalary(customerDTO.getSalary());
        customer.setSurname(customerDTO.getSurname());
        customer.setIdentityNumber(customerDTO.getIdentityNumber());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setCreditApplicationsList(customerDTO.getCreditApplicationsList());
        return customer;
    }
}
