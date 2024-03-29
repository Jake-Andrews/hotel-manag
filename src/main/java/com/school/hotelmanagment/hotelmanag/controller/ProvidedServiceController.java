package com.school.hotelmanagment.hotelmanag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.hotelmanagment.model.ProvidedServiceModel;
import com.school.hotelmanagment.repository.BookingRepository;
import com.school.hotelmanagment.repository.ServiceRepository;
import com.school.hotelmanagment.service.ProvidedService;

import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ProvidedServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProvidedServiceController.class);
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ProvidedService providedService;

    @GetMapping("/services")
    public String getServicesPage(Model model) {
        List<ProvidedServiceModel> services = providedService.getAllServices();
        model.addAttribute("services", services);
        model.addAttribute("bookings", bookingRepository.findAll());
        return "services";
    }

    @SuppressWarnings("null")
    @PostMapping("/services")
    public String addService(@RequestParam("bookingId") int bookingId,
            @Validated @NonNull @ModelAttribute ProvidedServiceModel service, BindingResult result) {
        if (result.hasErrors()) {
            logger.info("Error adding service for booking ID: {}.", bookingId);
            logger.info("BindingResult errors: {}", result.getAllErrors());
            return "services";
        }
        logger.info("Adding service for booking ID: {}.", bookingId);

        service = providedService.initializeService(service, bookingId);
        serviceRepository.save(service);

        logger.info("Service added successfully");

        return "redirect:/services";
    }
}