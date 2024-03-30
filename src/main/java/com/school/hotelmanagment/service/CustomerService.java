package com.school.hotelmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.hotelmanagment.model.Customer;
import com.school.hotelmanagment.repository.CustomerRepository;

/**
 * This class represents the service layer for managing customers in the hotel management system.
 * It provides methods to retrieve customer data from the repository.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Retrieves all customers from the repository.
     *
     * @return a list of all customers
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}