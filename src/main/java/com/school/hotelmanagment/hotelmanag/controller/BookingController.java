package com.school.hotelmanagment.hotelmanag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.hotelmanagment.model.Booking;
import com.school.hotelmanagment.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.validation.annotation.Validated;
import org.springframework.lang.NonNull;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public String getBookingsPage(Model model) {
        model.addAttribute("booking", new Booking());
        return "bookings";
    }

    @PostMapping("/bookings")
    public String addBooking(@Validated @NonNull @ModelAttribute Booking booking, BindingResult result) {
        if (result.hasErrors()) {
            return "bookings";
        }

        bookingRepository.save(booking);
        return "redirect:/bookings";
    }
}