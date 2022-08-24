package com.car.controllers;

import com.car.model.Booking;
import com.car.model.Car;
import com.car.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@RestController
@RequestMapping("/booking-api")
public class BookingController {

    IBookingService iBookingService;
    @Autowired
    public void setiBookingService(IBookingService iBookingService) {
        this.iBookingService = iBookingService;
    }

    /**
     *
     * @param booking the booking object
     * @param customerId the customer id
     * @return the status of the transaction
     */
    @PostMapping("/bookings/customerId/{customerId}")
    public ResponseEntity<Void> addBooking(@RequestBody Booking booking,@PathVariable("customerId") int customerId){
        iBookingService.addBooking(booking,customerId);
        return  ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     *
     * @param booking the booking object
     * @return the status of the transaction
     */
    @PutMapping("/bookings")
    public ResponseEntity<Void> updateBooking(@RequestBody Booking booking){
        iBookingService.updateBooking(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    /**
     *
     * @param bookingId the booking id of the booking
     * @return the status of the transaction along with headers
     */
    @DeleteMapping("/bookings/bookingId/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("bookingId") int bookingId){
        iBookingService.deleteById(bookingId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","deleting one booking by registration id "+bookingId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();

    }
    @GetMapping("/bookings/bookingId/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable("bookingId") int bookingId){
        Booking booking = iBookingService.getById(bookingId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting one booking by id");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(booking);

    }
    /**
     *
     * @return list of all bookings along with headers and status
     */

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAll(){
        List<Booking> bookings = iBookingService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting all bookings");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param startTime the start time of the booking
     * @return list of all bookings with the given start time along with headers and status
     */
    @GetMapping("/bookings/startTime/{startTime}")
    public ResponseEntity<List<Booking>> showByStartTime(@PathVariable("startTime") String startTime){

        Time nstartTime = Time.valueOf(startTime);
        List<Booking> bookings = iBookingService.getByStartTime(nstartTime);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings of start time "+nstartTime);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param endTime the end time of the booking
     * @return list of all bookings with the given end time along with headers and status
     */

    @GetMapping("/bookings/endTime/{endTime}")
    public ResponseEntity<List<Booking>> showByEndTime(@PathVariable("endTime") String endTime){
        Time nendTime = Time.valueOf(endTime);
        List<Booking> bookings = iBookingService.getByEndTime(nendTime);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings of end time "+nendTime);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param dateOfBooking the date of booking
     * @return list of all bookings with the given date of booking along with headers and status
     */
    @GetMapping("/bookings/dateOfBooking/{dateOfBooking}")
    public ResponseEntity<List<Booking>> showByDateOfBooking(@PathVariable("dateOfBooking") String dateOfBooking){
        LocalDate ndateOfBooking = LocalDate.parse(dateOfBooking);
        List<Booking> bookings = iBookingService.getByDateOfBooking(ndateOfBooking);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings on date of booking "+ndateOfBooking);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param paymentDone the payment status that whether payment is done or not
     * @return list of all bookings with the given payment status along with headers and status
     */
    @GetMapping("/bookings/paymentDone/{paymentDone}")
    public ResponseEntity<List<Booking>> showByPaymentDone(@PathVariable("paymentDone") boolean paymentDone){
        List<Booking> bookings = iBookingService.getByPaymentDone(paymentDone);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings of payment status "+paymentDone);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param totalCost the total cost of the booking
     * @return list of all bookings with the given total cost along with headers and status
     */
    @GetMapping("/bookings/totalCost/{totalCost}")
    public ResponseEntity<List<Booking>> showByCostLessThan(@PathVariable("totalCost") double totalCost){
        List<Booking> bookings = iBookingService.getByCostLessThan(totalCost);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings of whose total cost less than "+totalCost);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param paymentDone the payment status that whether payment is done or not
     * @param noOfHoursBooked the no of hours that the car is booked for
     * @return list of all bookings with the given payment status and no of hours along with headers and status
     */
    @GetMapping("/bookings/paymentDone/{paymentDone}/noOfHoursBooked/{noOfHoursBooked}")
    public ResponseEntity<List<Booking>> showByPaymentAndHours(@PathVariable("paymentDone") boolean paymentDone,@PathVariable("noOfHoursBooked") int noOfHoursBooked){
        List<Booking> bookings = iBookingService.getByPaymentAndHours(paymentDone,noOfHoursBooked);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings of payment status "+paymentDone+" , and  no of hours booked"+noOfHoursBooked);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @param carNumber the car number
     * @param noOfHoursBooked the no of hours that the car is booked for
     * @return list of all bookings with the given car number and no of hours along with headers and status
     */

    @GetMapping("/bookings/carNumber/{carNumber}/noOfHoursBooked/{noOfHoursBooked}")
    public ResponseEntity<List<Booking>> showByCarNumberAndHours(@PathVariable("carNumber") int carNumber,@PathVariable("noOfHoursBooked") int noOfHoursBooked){
        List<Booking> bookings = iBookingService.getByCarNumberAndHours(carNumber,noOfHoursBooked);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting bookings of car number "+carNumber+" , and  no of hours booked"+noOfHoursBooked);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(bookings);

    }

    /**
     *
     * @return the average cost of all bookings
     */
    @GetMapping("/bookings/average_cost")
    public ResponseEntity<Integer> getAverageOfTotalCost(){
        int averageOfTotalCOst = iBookingService.getAverageOfTotalCost();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting average of totalcost");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(averageOfTotalCOst);

    }
}
