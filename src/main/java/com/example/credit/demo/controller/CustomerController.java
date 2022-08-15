package com.example.credit.demo.controller;

import com.example.credit.demo.model.dto.CustomerDTO;
import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //returns all customers
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //creates a new customer
    @PostMapping
    public Customer create(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }

    @PutMapping
    public void updateCustomer(@RequestBody CustomerDTO customer){
        customerService.save(customer);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(name = "id") Long id){
        return customerService.getById(id);
    }
    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable(name = "id") Long id){
        customerService.delete(id);
    }

    @GetMapping("/search")
    public Customer getByIdentityNumber(@RequestParam("identityNumber")String identityNumber){
        return customerService.getByIdentityNumber(identityNumber);
    }
    @PostMapping("/{id}/apply")
    public void apply(@PathVariable Long id){
        customerService.apply(id);
    }
}
