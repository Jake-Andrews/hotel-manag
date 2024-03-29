package com.school.hotelmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.hotelmanagment.repository.BookingRepository;
import com.school.hotelmanagment.repository.ServiceRepository;
import com.school.hotelmanagment.model.Booking;
import com.school.hotelmanagment.model.ProvidedServiceModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProvidedService {
    private static final Logger logger = LoggerFactory.getLogger(ProvidedService.class);

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public List<ProvidedServiceModel> getAllServices() {
        return serviceRepository.findAll();
    }

    /**
     * Initializes a service by associating it with a booking.
     * 
     * @param service   The service to be initialized
     * @param bookingId The ID of the booking to associate the service with
     * @return The initialized service
     */

    public ProvidedServiceModel initializeService(ProvidedServiceModel service, int bookingId) {
        logger.info("Creating service with ID: {}", service.getId());

        // Fetch the booking based on the user's input
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        logger.info("Fetched booking with ID: {}", bookingId);

        // Create a new booking and set the customer and room
        // Booking tempBooking = new Booking();
        service.setBooking(booking);

        // Save the booking
        // bookingRepository.save(booking);
        logger.info("Set foreign ids and returned Service from method: initializeService");
        return service;
    }
}
