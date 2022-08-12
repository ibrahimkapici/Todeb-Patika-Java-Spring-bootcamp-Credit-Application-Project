package com.example.credit.demo.service;

import com.example.credit.demo.exception.EntityNotFoundException;
import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.mapper.CustomerMapper;
import com.example.credit.demo.repository.CustomerRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id){
        Optional<Customer> byId = customerRepository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    public Customer getByIdentityNumber(String identityNumber){
        Optional<Customer> getByIdentityNumber = customerRepository.findByIdentityNumber(identityNumber);
        return getByIdentityNumber.orElseThrow(()-> new RuntimeException("Customer not found"));
    }
    public Customer create(CustomerDTO customerDTO){
        Customer customer = CustomerMapper.toEntity(customerDTO);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        return  allCustomers;
    }

    public void delete(Long id) {
        getById(id);
        customerRepository.deleteById(id);
    }

    public Customer update(String identityNumber, CustomerDTO customer) {
        Optional<Customer> getById = customerRepository.findByIdentityNumber(identityNumber);
        if (!getById.isPresent())
            throw new EntityNotFoundException("Customer", "identityNumber: " + identityNumber);
            Customer updatedCustomer = getById.get();
            if(!StringUtils.isEmpty(customer.getName())){
                updatedCustomer.setName(customer.getName());
            }
             if(!StringUtils.isEmpty(customer.getSurname())){
                 updatedCustomer.setSurname(customer.getSurname());
             }
             if(!StringUtils.isEmpty(customer.getSalary())) {
                 updatedCustomer.setSalary(customer.getSalary());
             }
             if(!StringUtils.isEmpty(customer.getPhoneNumber())) {
                 updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
             }
             return customerRepository.save(updatedCustomer);
    }

}




