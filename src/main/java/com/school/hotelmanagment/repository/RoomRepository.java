package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.Room;
/**
 * This interface represents the repository for managing Room entities.
 * It extends the JpaRepository interface, providing CRUD operations for Room entities.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}