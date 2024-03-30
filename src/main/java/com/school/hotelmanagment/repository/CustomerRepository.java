package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.Customer;

/**
 * The CustomerRepository interface is responsible for providing CRUD operations
 * for the Customer entity.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}