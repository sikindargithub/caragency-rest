package com.car.service;

import com.car.exceptions.CarNotFoundException;
import com.car.model.Car;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public interface ICarService {

    // crud queries
    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int carNumber);
    List<Car> getAll();
    Car getById(int carNumber);

    // derived queries

    List<Car> getByBrandAndModel(String brand,String model) throws CarNotFoundException;
    List<Car> getByMileage(int mileage) throws CarNotFoundException;
    List<Car> getByCarRating(double carRating) throws CarNotFoundException;
    List<Car> getByCarType(String carType) throws CarNotFoundException;
    List<Car> getByBrand(String brand) throws CarNotFoundException;
    List<Car> getByFuelType(String fuelType) throws CarNotFoundException;
    List<Car> getByPricePerHourLessThan(double pricePerHour) throws CarNotFoundException;
    List<Car> getByNoOfSeats(int noOfSeats) throws CarNotFoundException;
    List<Car> getByColorAndCarRating(String color,double carRating) throws CarNotFoundException;
    List<Car> getByCarRatingAndMileage(double carRating,int mileage) throws CarNotFoundException;


    // custom queries
    List<Car> getByDistanceAndFuel(double kmsDriven,String fuelType) throws CarNotFoundException;
    List<Car> getByTransmissionAndInsurance(String transmission,boolean insuranced) throws CarNotFoundException;
    List<Car> getBySeatsAndPickup(int noOfSeats,String pickupType) throws CarNotFoundException;
    List<Car> getByTypeAndPrice(String carType,double pricePerHour) throws CarNotFoundException;
    List<Car> getByBrandAndPickupAndSeats(String brand,String pickupType,int noOfSeats) throws CarNotFoundException;
    List<Car> getByMileageAndRatingAndType(int mileage,double rating,String carType) throws CarNotFoundException;

    List<Car> getByCategoryAndSubCategory(String category,String subCategory);
    List<String> getDistinctCategories(String category);
}
