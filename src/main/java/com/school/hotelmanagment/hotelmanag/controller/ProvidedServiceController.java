package com.school.hotelmanagment.hotelmanag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProvidedServiceController {
    @GetMapping("/services")
    public String getServicesPage() {
        return "services";
    }
}
