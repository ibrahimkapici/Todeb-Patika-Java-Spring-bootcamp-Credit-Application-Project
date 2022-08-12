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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //returns all customers
    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //creates a new customer
    @PostMapping("/create")
    public Customer create(@RequestBody CustomerDTO customerDTO){
        return customerService.create(customerDTO);
    }

    //updates a customer
    @PutMapping("/{identityNumber}")
    public ResponseEntity updateCustomer(@PathVariable String identityNumber, @RequestBody CustomerDTO customer){
        Customer update = customerService.update(identityNumber, customer);
        if (update == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Customer could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }


    //deletes a customer
    @DeleteMapping
    public ResponseEntity deleteCustomer(@RequestParam(name = "id") Long id){
        try {
            customerService.delete(id);
        }
            catch (RuntimeException exception){
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.status(HttpStatus.OK).body("Related customer was deleted successfully");
    }
}
