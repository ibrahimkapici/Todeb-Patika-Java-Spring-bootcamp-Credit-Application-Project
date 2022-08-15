package com.example.credit.demo.service;

import com.example.credit.demo.model.entity.Customer;
import com.example.credit.demo.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getById() {


    }

    @Test
    void getByIdentityNumber_successful() {
        //init
        Customer expectedCustomer = getSampleTestCustomers().get(1);
        Optional<Customer> optExpectedCustomer = Optional.of(expectedCustomer);

        //stub
        Mockito.when(customerRepository.findByIdentityNumber(Mockito.any())).thenReturn(optExpectedCustomer);

        //then
        Customer actualCustomer = customerService.getByIdentityNumber("11122233346");

        Assert.assertEquals(actualCustomer.getIdentityNumber(), expectedCustomer.getIdentityNumber());
        Assert.assertEquals(actualCustomer.getPhoneNumber(), expectedCustomer.getPhoneNumber());
    }



    @Test
    void getAllCustomers() {
        //init step expected result
        List<Customer> expectedCustomers = new ArrayList<>();
        Customer customer = new Customer(1L, "11122233345", "Faruk", "Sırma", "5434773743", 9500D);
        Customer customer2 = new Customer(2L, "11122233346", "Yılmaz", "Yıldı", "5434763743", 4500D);
        Customer customer3 = new Customer(3L, "11124253346", "Hasan", "Şaş", "5435763343", 14500D);

        expectedCustomers.add(customer);
        expectedCustomers.add(customer2);
        expectedCustomers.add(customer3);

        //stub- when step
        Mockito.when(customerRepository.findAll()).thenReturn(expectedCustomers);

        //then - validate
        List<Customer> actualCustomerList = customerService.getAllCustomers();
        System.out.println("First" + expectedCustomers);

        Assert.assertEquals(expectedCustomers.size(), actualCustomerList.size());
        for (Customer currCustomer : expectedCustomers){
            actualCustomerList.stream().sorted(getCustomerComparator()).collect(Collectors.toList());
            for (int i = 0; i < expectedCustomers.size(); i++) {
                Customer currExpectedCustomer = expectedCustomers.get(i);
                Customer currActualCustomer = actualCustomerList.get(i);
                Assert.assertEquals(currExpectedCustomer.getId(), currActualCustomer.getId());
                Assert.assertEquals(currExpectedCustomer.getName(), currActualCustomer.getName());
                Assert.assertEquals(currExpectedCustomer.getSurname(), currActualCustomer.getSurname());


            }

            System.out.println("Second" + actualCustomerList);
        }

    }
    private List<Customer> getSampleTestCustomers() {
        List<Customer> sampleList = new ArrayList<>();
        Customer customer = new Customer(1L, "11122233345", "Faruk", "Sırma", "5434773743", 9500D);
        Customer customer2 = new Customer(2L, "11122233346", "Yılmaz", "Yıldı", "5434763743", 4500D);
        Customer customer3 = new Customer(3L, "11124253346", "Hasan", "Şaş", "5435763343", 14500D);
        sampleList.add(customer);
        sampleList.add(customer2);
        sampleList.add(customer3);
        return sampleList;
    }

    private static Comparator<Customer> getCustomerComparator() {
        return (o1, o2) -> {
            if (o1.getId() - o2.getId() < 0)
                return -1;
            if (o1.getId() - o2.getId() == 0)
                return 0;
            return 1;
        };
    }
}