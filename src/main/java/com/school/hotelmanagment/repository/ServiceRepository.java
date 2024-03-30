package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.ProvidedServiceModel;

/**
 * The ServiceRepository interface is responsible for providing CRUD operations
 * for the ProvidedServiceModel entity.
 */
@Repository
public interface ServiceRepository extends JpaRepository<ProvidedServiceModel, Integer> {

}