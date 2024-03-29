package com.school.hotelmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.hotelmanagment.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}