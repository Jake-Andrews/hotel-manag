package com.school.hotelmanagment.hotelmanag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookingController {
    @GetMapping("/bookings")
    public String getBookingsPage() {
        return "bookings";
    }
}
