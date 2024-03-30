package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.Booking;

/**
 * The BookingRepository interface is responsible for providing CRUD operations
 * for the Booking entity.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}