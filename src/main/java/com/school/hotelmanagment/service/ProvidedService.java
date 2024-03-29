package com.school.hotelmanagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.hotelmanagment.repository.ServiceRepository;
import com.school.hotelmanagment.model.ProvidedServiceModel;

@Service
public class ProvidedService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ProvidedServiceModel> getAllServices() {
        return serviceRepository.findAll();
    }
}
