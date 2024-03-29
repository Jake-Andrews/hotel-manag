package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}