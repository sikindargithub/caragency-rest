package com.car.repository;

import com.car.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Repository
public interface ICarRepository extends JpaRepository<Car,Integer> {

    // derived methods
    List<Car> findByBrandAndModel(String brand, String model);
    List<Car> findByMileage(int mileage);
    List<Car> findByCarRating(double carRating);
    List<Car> findByCarType(String carType);
    List<Car> findByBrand(String brand);
    List<Car> findByFuelType(String fuelType);
    List<Car> findByPricePerHourLessThan(double pricePerHour);
    List<Car> findByNoOfSeats(int noOfSeats);
    List<Car> findByColorAndCarRating(String color,double carRating);
    List<Car> findByCarRatingAndMileage(double carRating,int mileage);



    // custom queries
    @Query("from Car car where car.kmsDriven < ?1 and car.fuelType = ?2")
    List<Car> findByDistanceAndFuel(double kmsDriven,String fuelType);
    @Query("from Car car where car.transmission = ?1 and car.insuranced = ?2")
    List<Car> findByTransmissionAndInsurance(String transmission, boolean insuranced);
    @Query("from Car car where car.noOfSeats = ?1 and car.pickupType = ?2")
    List<Car> findBySeatsAndPickup(int noOfSeats,String pickupType);
    @Query("from Car car where car.carType = ?1 and car.pricePerHour = ?2")
    List<Car> findByTypeAndPrice(String carType,double pricePerHour);
    @Query("from Car car where car.brand = ?1 and car.pickupType = ?2 and car.noOfSeats = ?3")
    List<Car> findByBrandAndPickupAndSeats(String brand,String pickupType,int noOfSeats);
    @Query("from Car car where car.mileage = ?1 and car.carRating = ?2 and car.carType = ?3")
    List<Car> findByMileageAndCarRatingAndType(int mileage,double rating,String carType);
    @Query("select distinct carType from Car")
    List<String> findByDistinctCarTypes();
    @Query("select distinct brand from Car")
    List<String> findByDistinctBrands();
    @Query("select distinct fuelType from Car")
    List<String> findByDistinctFuelTypes();

//    List<Car> findByCarType(String subCategory);

}

