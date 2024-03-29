package com.school.hotelmanagment.hotelmanag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.hotelmanagment.model.ProvidedServiceModel;
import com.school.hotelmanagment.repository.ServiceRepository;
import com.school.hotelmanagment.service.ProvidedService;

import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;

@Controller
public class ProvidedServiceController {
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ProvidedService providedService;

    @GetMapping("/services")
    public String getServicesPage(Model model) {
        List<ProvidedServiceModel> services = providedService.getAllServices();
        model.addAttribute("services", services);
        return "services";
    }

    @PostMapping("/services")
    public String addService(@Validated @NonNull @ModelAttribute ProvidedServiceModel service, BindingResult result) {
        if (result.hasErrors()) {
            return "services";
        }

        serviceRepository.save(service);
        return "redirect:/services";
    }
}