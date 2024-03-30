package com.school.hotelmanagment.hotelmanag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.hotelmanagment.model.Booking;
import com.school.hotelmanagment.repository.BookingRepository;
import com.school.hotelmanagment.repository.CustomerRepository;
import com.school.hotelmanagment.repository.RoomRepository;
import com.school.hotelmanagment.service.BookingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The BookingController class is responsible for handling HTTP requests related to bookings in the hotel management system.
 * It provides methods for displaying the booking form, adding a new booking, and retrieving all bookings.
 */
@Controller
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingServices;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Displays the new booking form.
     *
     * @param model the model object to be used for rendering the view
     * @return the name of the view to be rendered
     */
    @GetMapping("/bookings")
    public String showNewBookingForm(Model model) {
        List<Booking> bookings = bookingServices.getAllBookings();
        model.addAttribute("bookings", bookings);
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());
        return "bookings";
    }

    /**
     * Adds a booking for a customer and a room.
     *
     * @param customerId the ID of the customer
     * @param roomId the ID of the room
     * @param booking the booking object to be added
     * @param result the binding result for validation errors
     * @return the view name to be displayed after adding the booking
     */
    @SuppressWarnings("null")
    @PostMapping("/bookings")
    public String addBooking(@RequestParam("customerId") int customerId, @RequestParam("roomId") int roomId,
            @Validated @NonNull @ModelAttribute Booking booking, BindingResult result) {
        if (result.hasErrors()) {
            logger.info("Adding booking for customer ID: {} and room ID: {} errored", customerId, roomId);
            logger.info("BindingResult errors: {}", result.getAllErrors());
            return "bookings";
        }

        logger.info("Adding booking for customer ID: {} and room ID: {}", customerId, roomId);

        booking = bookingServices.initalizeBooking(booking, customerId, roomId);
        bookingRepository.save(booking);

        logger.info("Booking added successfully");

        return "redirect:/bookings";
    }
}