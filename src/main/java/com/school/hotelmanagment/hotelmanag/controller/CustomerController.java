package com.school.hotelmanagment.hotelmanag.controller;

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

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String getCustomersPage(Model model) {
        model.addAttribute("customer", new Customer());
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