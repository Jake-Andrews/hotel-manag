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

/**
 * This class provides methods to manage bookings in the hotel management
 * system.
 * It interacts with the booking repository, customer repository, and room
 * repository
 * to perform CRUD operations on bookings.
 */
@Service
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Retrieves all bookings from the repository.
     *
     * @return a list of all bookings
     */
    public List<Booking> getAllBookings() {
        logger.info("Fetching all bookings from the repository");
        List<Booking> bookings = bookingRepository.findAll();
        logger.info("Fetched {} bookings", bookings.size());
        return bookings;
    }

    /**
     * Initializes the customerId and roomId foreign keys in the Booking entity.
     *
     * @param booking    the booking to be initialized
     * @param customerId the ID of the customer associated with the booking
     * @param roomId     the ID of the room associated with the booking
     * @return the initialized booking
     * @throws RuntimeException if the customer or room is not found
     */
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
        booking.setCustomer(customer);
        booking.setRoom(room);

        logger.info("Set foreign ids and returned Booking from method: initializeForeignIds");
        return booking;
    }
}