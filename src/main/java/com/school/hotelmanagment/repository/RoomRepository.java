package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}