package com.school.hotelmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.hotelmanagment.model.Room;
import com.school.hotelmanagment.repository.RoomRepository;

/**
 * This class represents the service layer for managing rooms in a hotel.
 */
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Retrieves all the rooms in the hotel.
     *
     * @return a list of Room objects representing all the rooms in the hotel.
     */
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}