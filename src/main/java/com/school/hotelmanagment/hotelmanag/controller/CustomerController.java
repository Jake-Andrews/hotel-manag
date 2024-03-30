package com.school.hotelmanagment.hotelmanag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;

import com.school.hotelmanagment.model.Customer;
import com.school.hotelmanagment.repository.CustomerRepository;
import com.school.hotelmanagment.service.CustomerService;

/**
 * The CustomerController class is responsible for handling HTTP requests related to customers.
 * It provides methods for retrieving customers and adding new customers.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    /**
     * Retrieves the customers page.
     *
     * @param model the model object to be populated with data
     * @return the name of the view template to be rendered
     */
    @GetMapping("/customers")
    public String getCustomersPage(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    /**
        * Adds a new customer to the system.
        *
        * @param customer The customer object to be added.
        * @param result   The binding result for validation errors.
        * @return The view name to be displayed after adding the customer.
        */
    @PostMapping("/customers")
    public String addCustomer(@Validated @NonNull @ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customers";
        }

        customerRepository.save(customer);
        return "redirect:/customers";
    }
}