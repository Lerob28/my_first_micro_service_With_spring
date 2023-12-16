package org.lerob.customerservice.web;

import lombok.RequiredArgsConstructor;
import org.lerob.customerservice.entities.Customer;
import org.lerob.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> customerList() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @PostMapping("/add")
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

}
