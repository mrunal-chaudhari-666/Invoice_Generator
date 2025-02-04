package com.example.invoicegenerator.task.service;

import com.example.invoicegenerator.task.ResourceNotFoundException;
import com.example.invoicegenerator.task.entities.Customer;
import com.example.invoicegenerator.task.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

