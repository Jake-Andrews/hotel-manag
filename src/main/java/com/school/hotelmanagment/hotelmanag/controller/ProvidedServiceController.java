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

/**
 * Controller class for handling provided services.
 */
@Controller
public class ProvidedServiceController {

    private static final Logger logger = LoggerFactory.getLogger(ProvidedServiceController.class);
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ProvidedService providedService;

    /**
     * Handles GET requests for the services page.
     * Retrieves all services and bookings from the database and adds them to the model.
     * @param model the model object to add attributes to
     * @return the name of the services view
     */
    @GetMapping("/services")
    public String getServicesPage(Model model) {
        List<ProvidedServiceModel> services = providedService.getAllServices();
        model.addAttribute("services", services);
        model.addAttribute("bookings", bookingRepository.findAll());
        return "services";
    }

    /**
     * Handles POST requests for adding a new service.
     * Validates the provided service model and adds it to the database.
     * @param bookingId the ID of the booking associated with the service
     * @param service the provided service model to add
     * @param result the binding result object for validation errors
     * @return the name of the services view if there are validation errors, otherwise redirects to the services page
     */
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