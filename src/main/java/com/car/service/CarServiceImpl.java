package com.car.service;

import com.car.exceptions.CarNotFoundException;
import com.car.model.Car;
import com.car.repository.ICarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Service
public class CarServiceImpl implements ICarService{

    ICarRepository iCarRepository;
    @Autowired
    public void setiCarRepository(ICarRepository iCarRepository) {
        this.iCarRepository = iCarRepository;
    }

    /**
     * Method is used to save the car object
     * @param car the car object
     */
    @Override
    public void addCar(Car car) {
        iCarRepository.save(car);
    }

    /**
     * Method is used to update the car object
     * @param car the car object
     */
    @Override
    public void updateCar(Car car) {
        iCarRepository.save(car);
    }

    /**
     * Method is used to delete the car object
     * @param carNumber  the car number
     */
    @Override
    public void deleteCar(int carNumber) {
        iCarRepository.deleteById(carNumber);
    }

    /**
     *
     * @return list of all cars
     */
    @Override
    public List<Car> getAll() {
        return iCarRepository.findAll();
    }

    /**
     *
     * @param carNumber the car number
     * @return the car object by using unique car number
     */
    @Override
    public Car getById(int carNumber) {
        return iCarRepository.findById(carNumber).orElseThrow(()-> new CarNotFoundException("car not found"));
    }

    /**
     *
     * @param brand the brand of the car
     * @param model the model of the car
     * @return list of all cars with the given brand and model
     * @throws CarNotFoundException if cars with the given brand and model are not found
     */
    @Override
    public List<Car> getByBrandAndModel(String brand, String model) {
        List<Car> carsList = iCarRepository.findByBrandAndModel(brand,model).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of brand "+brand+" and model "+model+" are not found");
        return carsList;
    }

    /**
     *
     * @param mileage the mileage of the car
     * @return list of all cars with the given mileage
     * @throws CarNotFoundException if cars with the given mileage are not found
     */
    @Override
    public List<Car> getByMileage(int mileage) {
        List<Car> carsList = iCarRepository.findByMileage(mileage).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of mileage "+mileage+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByCarRating(double carRating)  {
        List<Car> carsList = iCarRepository.findByCarRating(carRating).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of car rating "+carRating+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByCarType(String carType) throws CarNotFoundException {
        List<Car> carsList = iCarRepository.findByCarType(carType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of car type "+carType+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByBrand(String brand) throws CarNotFoundException {
        List<Car> carsList = iCarRepository.findByBrand(brand).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of brand "+brand+" are not found");
        return carsList;
    }

    @Override
    public List<Car> getByFuelType(String fuelType) throws CarNotFoundException {
        List<Car> carsList = iCarRepository.findByFuelType(fuelType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of fuel type "+fuelType+" are not found");
        return carsList;
    }

    /**
     *
     * @param pricePerHour the price per hour of the car
     * @return list of all cars with the given price per hour
     * @throws CarNotFoundException if cars with the given price per hour are not found
     */
    @Override
    public List<Car> getByPricePerHourLessThan(double pricePerHour) {
        List<Car> carsList = iCarRepository.findByPricePerHourLessThan(pricePerHour).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of price per hour "+pricePerHour+" are not found");
        return carsList;
    }

    /**
     *
     * @param noOfSeats the no of seats that the car is having
     * @return list of all cars with the given no of seats
     * @throws CarNotFoundException if cars with the given no of seats are not found
     */
    @Override
    public List<Car> getByNoOfSeats(int noOfSeats) {
        List<Car> carsList = iCarRepository.findByNoOfSeats(noOfSeats).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of no of seats "+noOfSeats+" are not found");
        return carsList;
    }

    /**
     *
     * @param color the color of the car
     * @param carRating the car rating
     * @return list of all cars with the given color and car rating
     * @throws CarNotFoundException if cars with the given color and car rating are not found
     */
    @Override
    public List<Car> getByColorAndCarRating(String color, double carRating) {
        List<Car> carsList = iCarRepository.findByColorAndCarRating(color,carRating).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of "+color+" and "+carRating+" are not found");
        return carsList;
    }

    /**
     *
     * @param carRating the car rating
     * @param mileage the mileage of the car
     * @return list of all cars with the given car rating and mileage
     * @throws CarNotFoundException if cars with the given car rating and mileage are not found
     */
    @Override
    public List<Car> getByCarRatingAndMileage(double carRating, int mileage) {
        List<Car> carsList = iCarRepository.findByCarRatingAndMileage(carRating,mileage).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of "+carRating+" and "+mileage+" are not found");
        return carsList;
    }

    /**
     *
     * @param kmsDriven the kilometers travelled by th car
     * @param fuelType the fuel type of the car
     * @return the list of all cars with the given kms driven and fuel type
     * @throws CarNotFoundException if cars with the given kms driven and fuel type are not found
     */
    @Override
    public List<Car> getByDistanceAndFuel(double kmsDriven, String fuelType) {
        List<Car> carsList = iCarRepository.findByDistanceAndFuel(kmsDriven,fuelType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsList.isEmpty())
            throw new CarNotFoundException("Cars of kms driven "+kmsDriven+" and fuel type"+fuelType+" are not found");
        return carsList;
    }
    /**
     *
     * @param transmission the transmission type of the car
     * @param insuranced the status of the car insurance
     * @return the list of all cars with given transmission type and insurance status
     * @throws CarNotFoundException if cars with the given transmission type and insurance status are not found
     */
    @Override
    public List<Car> getByTransmissionAndInsurance(String transmission, boolean insuranced) {
        List<Car> carsByTransmissionAndInsurance = iCarRepository.findByTransmissionAndInsurance(transmission,insuranced).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsByTransmissionAndInsurance.isEmpty())
            throw new CarNotFoundException("cars of transmission "+transmission+" and insurance "+insuranced+" are not found");
        return carsByTransmissionAndInsurance;
    }

    /**
     *
     * @param noOfSeats the no of the seats of the car
     * @param pickupType the pickup type of the car
     * @return the list of all cars with the given no of seats and pickup type
     * @throws CarNotFoundException if cars with the given no of seats and pickup type are not found
     */
    @Override
    public List<Car> getBySeatsAndPickup(int noOfSeats, String pickupType) {
        List<Car> carsBySeatsAndPickup = iCarRepository.findBySeatsAndPickup(noOfSeats,pickupType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsBySeatsAndPickup.isEmpty())
            throw new CarNotFoundException("Cars of no of seats"+noOfSeats+" and pick up type "+pickupType+" are not found");
        return carsBySeatsAndPickup;
    }
    /**
     *
     * @param carType the car type
     * @param pricePerHour the price per hour of the car
     * @return the list of all cars with the given car type and price per hour
     * @throws CarNotFoundException if cars with the given car type and price per hour are not found
     */
    @Override
    public List<Car> getByTypeAndPrice(String carType, double pricePerHour) {
        List<Car> carsTypeAndPrice = iCarRepository.findByTypeAndPrice(carType,pricePerHour).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsTypeAndPrice.isEmpty())
            throw new CarNotFoundException("Cars of car type "+carType+" and price per hour "+pricePerHour+" are not found");
        return carsTypeAndPrice;
    }

    /**
     *
     * @param brand the brand of the car
     * @param pickupType the pickup type of the car
     * @param noOfSeats the no of seats of the car
     * @return the list of all cars with given brand,pickup type and no of seats
     * @throws CarNotFoundException if cars with the given brand ,pickup type and no of seats are not found
     */
    @Override
    public List<Car> getByBrandAndPickupAndSeats(String brand, String pickupType, int noOfSeats) {
        List<Car> carsByBrandAndPickupAndSeats = iCarRepository.findByBrandAndPickupAndSeats(brand,pickupType,noOfSeats).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsByBrandAndPickupAndSeats.isEmpty())
            throw new CarNotFoundException("Cars of brand "+brand+" , pick up type "+pickupType+" and no of seats "+noOfSeats+" are not found");
        return carsByBrandAndPickupAndSeats;
    }

    /**
     *
     * @param mileage the mileage of the car
     * @param carRating the car rating
     * @param carType the car type
     * @return the list of all cars with the given mileage ,car rating and car type
     * @throws CarNotFoundException if cars with the given mileage,car rating and car type are not found
     */
    @Override
    public List<Car> getByMileageAndRatingAndType(int mileage, double carRating, String carType) {
        List<Car> carsByMileageAndRatingAndType = iCarRepository.findByMileageAndCarRatingAndType(mileage,carRating,carType).stream().sorted(Comparator.comparing(Car::getBrand)).collect(Collectors.toList());
        if(carsByMileageAndRatingAndType.isEmpty())
            throw new CarNotFoundException("Cars of mileage "+mileage+",rating "+carRating+" and car type "+carType+" are not found");
        return carsByMileageAndRatingAndType;
    }


    @Override
    public List<Car> getByCategoryAndSubCategory(String category, String subCategory) {
        if(category.equals("carType"))
            return iCarRepository.findByCarType(subCategory);
        else if(category.equals("brand"))
            return iCarRepository.findByBrand(subCategory);
        else if (category.equals("fuelType"))
            return iCarRepository.findByFuelType(subCategory);
        else
            return null;
    }

    @Override
    public List<String> getDistinctCategories(String category) {
        if(category.equals("carType"))
            return iCarRepository.findByDistinctCarTypes();
        else if(category.equals("brand"))
            return iCarRepository.findByDistinctBrands();
        else if(category.equals("fuelType"))
            return iCarRepository.findByDistinctFuelTypes();
        return null;
    }


}
