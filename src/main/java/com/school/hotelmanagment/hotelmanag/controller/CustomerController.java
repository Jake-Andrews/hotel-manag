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

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String getCustomersPage(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @PostMapping("/customers")
    public String addCustomer(@Validated @NonNull @ModelAttribute Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customers";
        }

        customerRepository.save(customer);
        return "redirect:/customers";
    }
}