package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.ProvidedService;

@Repository
public interface ServiceRepository extends JpaRepository<ProvidedService, Integer> {

}