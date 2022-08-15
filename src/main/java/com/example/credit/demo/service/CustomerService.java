package com.example.credit.demo.service;

import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.CreditApplication;
import com.example.credit.demo.model.entity.CreditScore;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.model.mapper.CustomerMapper;
import com.example.credit.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CreditScoreService creditScoreService;
    private final DecisionService decisionService;

    public ResponseEntity<Customer> getById(Long id){
        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(byId.get());
    }

    public Customer getByIdentityNumber(String identityNumber){
        Optional<Customer> getByIdentityNumber = customerRepository.findByIdentityNumber(identityNumber);
        return getByIdentityNumber.orElseThrow(()-> new RuntimeException("Customer not found"));
    }
    public Customer save(CustomerDTO customerDTO){
        Customer customer = CustomerMapper.toEntity(customerDTO);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void delete(Long id) {
        Customer customer = customerRepository.findById(id).get();
        customerRepository.delete(customer);
    }

    public void update(Customer customer) {
        customerRepository.save(customer);
//        Optional<Customer> getById = customerRepository.findById(id);
//        if (getById.isPresent()) {
//            Customer customer = getById.get();
//            if (!ObjectUtils.isEmpty(updatedCustomer.getName())) {
//                customer.setName(updatedCustomer.getName());
//            }
//            if (!ObjectUtils.isEmpty(updatedCustomer.getSurname())) {
//                customer.setSurname(updatedCustomer.getSurname());
//            }
//            if (!ObjectUtils.isEmpty(updatedCustomer.getSalary())) {
//                customer.setSalary(updatedCustomer.getSalary());
//            }
//            if (!ObjectUtils.isEmpty(updatedCustomer.getPhoneNumber())) {
//                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
//            }
//            customerRepository.save(customer);
//        }
    }
    public ResponseEntity apply(Long id){

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (!optionalCustomer.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
        Customer customer = optionalCustomer.get();
        CreditScore result = creditScoreService.getByIdentityNumber(customer.getIdentityNumber());
        CreditApplication creditApplication = decisionService.decide(customer, result);

        customer.addCreditApplication(creditApplication);

        save(CustomerMapper.toDTO(customer));

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}




