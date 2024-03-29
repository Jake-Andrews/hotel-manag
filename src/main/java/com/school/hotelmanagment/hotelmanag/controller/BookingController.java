package com.school.hotelmanagment.hotelmanag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.hotelmanagment.model.Booking;
import com.school.hotelmanagment.model.Customer;
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

@Controller
public class BookingController {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingService bookingServices;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/bookings")
    public String showNewBookingForm(Model model) {
        List<Booking> bookings = bookingServices.getAllBookings();
        model.addAttribute("bookings", bookings);
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("rooms", roomRepository.findAll());
        return "bookings";
    }

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