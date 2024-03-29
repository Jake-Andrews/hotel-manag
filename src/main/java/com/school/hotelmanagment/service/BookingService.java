package com.school.hotelmanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.hotelmanagment.model.Booking;
import com.school.hotelmanagment.model.Customer;
import com.school.hotelmanagment.model.Room;
import com.school.hotelmanagment.repository.BookingRepository;
import com.school.hotelmanagment.repository.CustomerRepository;
import com.school.hotelmanagment.repository.RoomRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Booking> getAllBookings() {
        logger.info("Fetching all bookings from the repository");
        List<Booking> bookings = bookingRepository.findAll();
        logger.info("Fetched {} bookings", bookings.size());
        return bookings;
    }

    public Booking initalizeBooking(Booking booking, int customerId, int roomId) {
        logger.info("Creating booking with ID: {}", booking.getId());

        // Fetch the customer based on the user's input
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        logger.info("Fetched customer with ID: {}", customerId);

        // Fetch the room based on the user's input
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        logger.info("Fetched room with ID: {}", roomId);

        // Create a new booking and set the customer and room
        // Booking tempBooking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);

        // Save the booking
        // bookingRepository.save(booking);
        logger.info("Set foreign ids and returned Booking from method: initializeForeignIds");
        return booking;
    }
}