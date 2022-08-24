package com.car.service;

import com.car.exceptions.CarAgencyNotFoundException;
import com.car.model.CarAgency;
import com.car.model.CarAgencyView;

import java.time.LocalDate;
import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public interface ICarAgencyService {
    // Crud queries
    void addCarAgency(CarAgency carAgency);
    void updateCarAgency(CarAgency carAgency);
    void deleteById(int registrationId);
    CarAgency getById(int registrationId) throws CarAgencyNotFoundException;
    List<CarAgency> getAll();
    
    // Derived queries
    List<CarAgency> getByAgencyName(String agencyName) throws CarAgencyNotFoundException;
    List<CarAgency> getByRating(double rating) throws CarAgencyNotFoundException;
    List<CarAgency> getByExperience(int experience) throws CarAgencyNotFoundException;
    
    // Custom queries
    List<CarAgency> getByDate(LocalDate establishedDate) throws CarAgencyNotFoundException;

    // View
    List<CarAgencyView> getAllCarAgencies();
}
