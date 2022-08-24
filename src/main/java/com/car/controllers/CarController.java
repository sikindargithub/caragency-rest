package com.car.controllers;

import com.car.model.Car;
import com.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@RestController
@RequestMapping("/car-api")
@CrossOrigin("http://localhost:4200")
public class CarController {

    ICarService iCarService;

    @Autowired
    public void setiCarService(ICarService iCarService) {
        this.iCarService = iCarService;
    }

    /**
     *
     * @param car the car object
     * @return status of the transaction
     */
    @PostMapping("/cars")
    public ResponseEntity<Void> addCar(@RequestBody Car car){
        iCarService.addCar(car);
        return  ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     *
     * @param car the car object
     * @return status of the transaction
     */
    @PutMapping("/cars")
    public ResponseEntity<Void> updateCar(@RequestBody Car car){
        iCarService.updateCar(car);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    /**
     *
     * @param carNumber the car number
     * @return status of the transaction along with headers
     */
    @DeleteMapping("/cars/carNumber/{carNumber}")
    public ResponseEntity<Void> deleteCar(@PathVariable("carNumber") int carNumber){
        iCarService.deleteCar(carNumber);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","deleting one car by car number "+carNumber);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();

    }

    /**
     *
     * @return list of all cars along with headers and status
     */
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAll(){
        List<Car> cars = iCarService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting all cars");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);

    }

    /**
     *
     * @param carNumber the car number
     * @return car object along with headers and status
     */
    @GetMapping("/cars/carNumber/{carNumber}")
    public ResponseEntity<Car> getById(@PathVariable("carNumber") int carNumber){
        Car car = iCarService.getById(carNumber);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting one car by car number "+carNumber);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(car);

    }

    /**
     *
     * @param brand the brand of the car
     * @param model the model of the car
     * @return list of all cars with given brand and model along with headers and status
     */
    // derived methods
    @GetMapping("/cars/brand/{brand}/model/{model}")
    public ResponseEntity<List<Car>> getByBrandAndModel(@PathVariable("brand") String brand,@PathVariable("model") String model){
        List<Car> cars = iCarService.getByBrandAndModel(brand,model);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by brand "+brand+" and model "+model);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);

    }

    /**
     *
     * @param mileage the mileage of the car
     * @return list of all cars with given mileage along with headers and status
     */
    @GetMapping("/cars/mileage/{mileage}")
    public ResponseEntity<List<Car>> getByMileage(@PathVariable("mileage")int mileage){
        List<Car> cars = iCarService.getByMileage(mileage);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by mileage "+mileage);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    @GetMapping("/cars/carRating/{carRating}")
    public ResponseEntity<List<Car>> getByCarRating(@PathVariable("carRating")double carRating){
        List<Car> cars = iCarService.getByCarRating(carRating);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by car rating "+carRating);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    /**
     *
     * @param pricePerHour the price per hour of the car
     * @return list of all cars with given price per hour along with headers and status
     */
    @GetMapping("/cars/pricePerHour/{pricePerHour}")
    public ResponseEntity<List<Car>> getByPricePerHourLessThan(@PathVariable("pricePerHour")double pricePerHour){
        List<Car> cars = iCarService.getByPricePerHourLessThan(pricePerHour);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by price per hour less than "+pricePerHour);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param noOfSeats the no of seats that the car is having
     * @return list of all cars with given no of seats along with headers and status
     */
    @GetMapping("/cars/noOfSeats/{noOfSeats}")
    public ResponseEntity<List<Car>> getByNoOfSeats(@PathVariable("noOfSeats") int noOfSeats){
        List<Car> cars = iCarService.getByNoOfSeats(noOfSeats);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by no of seats "+noOfSeats);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param color the color of the car
     * @param carRating the car rating
     * @return list of all cars with given color and car rating along with headers and status
     */
    @GetMapping("/cars/color/{color}/carRating/{carRating}")
    public ResponseEntity<List<Car>>  getByColorAndRating(@PathVariable("color") String color,@PathVariable("carRating") double carRating){
        List<Car> cars = iCarService.getByColorAndCarRating(color,carRating);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by color "+color+" and rating "+carRating);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param rating the car rating
     * @param mileage the mileage of the car
     * @return list of all cars with given car rating and mileage along with headers and status
     */
    @GetMapping("/cars/carRating/{carRating}/mileage/{mileage}")
    public ResponseEntity<List<Car>> getByCarRatingAndMileage(@PathVariable("carRating") double rating,@PathVariable("mileage") int mileage){
        List<Car> cars = iCarService.getByCarRatingAndMileage(rating,mileage);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by rating "+rating+" and mileage "+mileage);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param kmsDriven the kilometers the car has driven
     * @param fuelType the fuel type of the car
     * @return list of all cars with given kms driven and fuel type along with headers and status
     */

    // custom queries
    @GetMapping("/cars/kmsDriven/{kmsDriven}/fuelType/{fuelType}")
    public ResponseEntity<List<Car>> getByDistanceAndFuel(@PathVariable("kmsDriven") double kmsDriven,@PathVariable("fuelType") String fuelType){
        List<Car> cars = iCarService.getByDistanceAndFuel(kmsDriven,fuelType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by kms driven "+kmsDriven+" and fuel type "+fuelType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param transmission the transmission type of the car
     * @param insuranced the insurance status of the car
     * @return list of all cars with given car transmission and insuranced along with headers and status
     */
    @GetMapping("/cars/transmission/{transmission}/insuranced/{insuranced}")
    public ResponseEntity<List<Car>> getByTransAndInsurance(@PathVariable("transmission") String transmission,@PathVariable("insuranced") boolean insuranced){
        List<Car> cars = iCarService.getByTransmissionAndInsurance(transmission,insuranced);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by transmission "+transmission+" and insurance "+insuranced);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param noOfSeats the no of seats that the car is having
     * @param pickupType the pickup type of the car
     * @return list of all cars with given car no of seats and pickup type along with headers and status
     */
    @GetMapping("/cars/noOfSeats/{noOfSeats}/pickupType/{pickupType}")
    public ResponseEntity<List<Car>>  getBySeatsAndPickup(@PathVariable("noOfSeats") int noOfSeats,@PathVariable("pickupType") String pickupType){
        List<Car> cars = iCarService.getBySeatsAndPickup(noOfSeats,pickupType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by no of seats "+noOfSeats+" and pickup type "+pickupType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param carType the car type
     * @param pricePerHour the price per hour that the car is having
     * @return
     */
    @GetMapping("/cars/carType/{carType}/pricePerHour/{pricePerHour}")
    public ResponseEntity<List<Car>>  getByTypeAndPrice(@PathVariable("carType") String carType,@PathVariable("pricePerHour")double pricePerHour){
        List<Car> cars = iCarService.getByTypeAndPrice(carType,pricePerHour);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by car type "+carType+" and price per hour "+pricePerHour);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param brand the brand of the car
     * @param pickupType the pickup type of the car
     * @param noOfSeats no of the seats of the car
     * @return the list of all cars with given brand,pickup type and no of seats
     */
    @GetMapping("/cars/brand/{brand}/pickupType/{pickupType}/noOfSeats/{noOfSeats}")
    public ResponseEntity<List<Car>> getByBrandAndPickupAndSeats(@PathVariable("brand") String brand,@PathVariable("pickupType") String pickupType,@PathVariable("noOfSeats")int noOfSeats){
        List<Car> cars = iCarService.getByBrandAndPickupAndSeats(brand,pickupType,noOfSeats);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by brand "+brand+" , pickup type "+pickupType+" and no of seats "+noOfSeats);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }

    /**
     *
     * @param mileage the mileage of the car
     * @param rating the rating of the car
     * @param carType the car type
     * @return the list of all cars with the given mileage,rating and car type
     */
    @GetMapping("/cars/mileage/{mileage}/rating/{rating}/carType/{carType}")
    public ResponseEntity<List<Car>> getByMileageAndRatingAndType(@PathVariable("mileage") int mileage,@PathVariable("rating") double rating,@PathVariable("carType") String carType){
        List<Car> cars = iCarService.getByMileageAndRatingAndType(mileage,rating,carType);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting cars by mileage "+mileage+" ,rating "+rating+" and car type "+carType);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(cars);
    }
    @GetMapping("/cars/distinct/{category}")
    public ResponseEntity<List<String>> getSubCategories(@PathVariable("category")String category){
        List<String> distinctCategory  = iCarService.getDistinctCategories(category);
        return ResponseEntity.ok().body(distinctCategory);
    }


    @GetMapping("/cars/choice")
    public ResponseEntity<List<Car>> getByCategoryAndSubCategory(@RequestParam("category") String category,@RequestParam("subCategory") String subCategory){
        List<Car> carList = iCarService.getByCategoryAndSubCategory(category,subCategory);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Getting all car of  "+category+" and "+subCategory);
        return ResponseEntity.ok().headers(httpHeaders).body(carList);

    }

}
