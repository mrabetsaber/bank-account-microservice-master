package net.mrabet.customer.web;

import net.mrabet.customer.entities.Customer;
import net.mrabet.customer.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository ;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        return customerRepository.findById(id).get();
    }




}
