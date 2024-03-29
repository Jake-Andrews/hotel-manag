package com.school.hotelmanagment.hotelmanag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.hotelmanagment.model.ProvidedService;
import com.school.hotelmanagment.repository.ServiceRepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;

@Controller
public class ProvidedServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services")
    public String getServicesPage(Model model) {
        model.addAttribute("service", new ProvidedService());
        return "services";
    }

    @PostMapping("/services")
    public String addService(@Validated @NonNull @ModelAttribute ProvidedService service, BindingResult result) {
        if (result.hasErrors()) {
            return "services";
        }

        serviceRepository.save(service);
        return "redirect:/services";
    }
}