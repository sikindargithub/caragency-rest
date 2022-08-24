package com.car.controllers;

import com.car.model.Car;
import com.car.model.CarAgency;
import com.car.model.CarAgencyView;
import com.car.service.ICarAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@RestController
@RequestMapping("/caragency-api")
@CrossOrigin("http://localhost:4200")
public class CarAgencyController {


    ICarAgencyService iCarAgencyService;
    @Autowired
    public void setiCarAgencyService(ICarAgencyService iCarAgencyService) {
        this.iCarAgencyService = iCarAgencyService;
    }

    /**
     *
     * @param carAgency the car agency object
     * @return status of the transaction
     */
    @PostMapping("/caragencies")
    public ResponseEntity<Void> addCarAgency(@RequestBody CarAgency carAgency){
        Set<Car> cars = carAgency.getCars();
        cars.forEach(car -> car.setCarAgency(carAgency));
        iCarAgencyService.addCarAgency(carAgency);
        return  ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     *
     * @param CarAgency the car agency object
     * @return status of the transaction
     */
    @PutMapping("/caragencies")
    public ResponseEntity<Void> updateCarAgency(@RequestBody CarAgency CarAgency){
        iCarAgencyService.updateCarAgency(CarAgency);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    /**
     *
     * @param registrationId the registration id of the car agency
     * @return status of the transaction along with headers
     */
    @DeleteMapping("/caragencies/registrationId/{registrationId}")
    public ResponseEntity<Void> deleteCarAgency(@PathVariable("registrationId") int registrationId){
        iCarAgencyService.deleteById(registrationId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","deleting one car agency by registration id "+registrationId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();

    }

    /**
     *
     * @param registrationId the registration id of the car agency
     * @return car agency object along with headers and status
     */
    @GetMapping("/caragencies/registrationId/{registrationId}")
    public ResponseEntity<CarAgency> showById(@PathVariable("registrationId") int  registrationId){
        CarAgency carAgency = iCarAgencyService.getById(registrationId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by registration id"+registrationId);
        return ResponseEntity.ok().headers(httpHeaders).body(carAgency);

    }

    /**
     *
     * @return list of all car agencies along with headers and status
     */
    @GetMapping("/caragencies")
    public ResponseEntity<List<CarAgency>> getAll(){
        List<CarAgency> carAgencyList = iCarAgencyService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting all car agencies");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(carAgencyList);

    }

    /**
     *
     * @param agencyName the name of the car agency
     * @return list of all car agencies with the given agency name along with headers and status
     */
    @GetMapping("/caragencies/agencyName/{agencyName}")
    public ResponseEntity<List<CarAgency>> showByAgencyName(@PathVariable("agencyName") String agencyName){
        List<CarAgency> carAgencyList = iCarAgencyService.getByAgencyName(agencyName);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by agency name"+agencyName);
        return ResponseEntity.ok().headers(httpHeaders).body(carAgencyList);

    }

    /**
     *
     * @param rating rating of the car agency
     * @return list of all car agencies with the given rating along with headers and status
     */
    @GetMapping("/caragencies/rating/{rating}")
    public ResponseEntity<List<CarAgency>> showByRating( @PathVariable("rating") double rating){
        List<CarAgency> carAgencyList = iCarAgencyService.getByRating(rating);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by rating "+rating);
        return ResponseEntity.ok().headers(httpHeaders).body(carAgencyList);

    }

    /**
     *
     * @param experience the experience of car agency
     * @return list of all car agencies with the given experience along with headers and status
     */
    @GetMapping("/caragencies/experience")
    public ResponseEntity<List<CarAgency>> showByExperience(@RequestParam("experience") int experience){
        List<CarAgency> carAgencyList = iCarAgencyService.getByExperience(experience);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by experience "+experience);
        return ResponseEntity.ok().headers(httpHeaders).body(carAgencyList);

    }

    /**
     *
     * @param establishedDate the established date of the car agency
     * @return list of all car agencies with the given experience along with headers and status
     */
    @GetMapping("/caragencies/establishedDate/{establishedDate}")
    public ResponseEntity<List<CarAgency>> showByDate(@PathVariable("establishedDate") LocalDate establishedDate){
        List<CarAgency> carAgencyList = iCarAgencyService.getByDate(establishedDate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by established date "+establishedDate);
        return ResponseEntity.ok().headers(httpHeaders).body(carAgencyList);

    }

    /**
     *
     * @return list of all car agencies which contains some fields of the dependent classes along with headers and status
     */
    @GetMapping("/caragencies/all")
    public ResponseEntity<List<CarAgencyView>> showAllCarAgencies() {
        List<CarAgencyView> carAgencies = iCarAgencyService.getAllCarAgencies();
        ResponseEntity<List<CarAgencyView>> carAgencyResponse = ResponseEntity.ok().body(carAgencies);
        return carAgencyResponse;
    }
}
