package com.car.repository;

import com.car.model.CarAgency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Repository
public interface ICarAgencyRepository extends JpaRepository<CarAgency,Integer> {

    // Derived queries
    List<CarAgency> findByAgencyName(String agencyName);
    List<CarAgency> findByRating(double rating);
    List<CarAgency> findByExperience(int experience);

    // Custom queries
    @Query("from CarAgency carAgency where carAgency.establishedDate = ?1")
    List<CarAgency> findByDate(LocalDate establishedDate);



}
