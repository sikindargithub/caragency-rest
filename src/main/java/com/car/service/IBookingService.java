package com.car.service;

import com.car.exceptions.BookingNotFoundException;
import com.car.model.Booking;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public interface IBookingService {

    // Crud queries
    void addBooking(Booking booking,int customerId);
    void updateBooking(Booking booking);
    void deleteById(int bookingId);
    Booking getById(int bookingId) throws BookingNotFoundException;
    List<Booking> getAll();
    
    // Derived queries
    List<Booking> getByStartTime(Time startTime) throws BookingNotFoundException;
    List<Booking> getByEndTime(Time endTime) throws BookingNotFoundException;
    List<Booking> getByDateOfBooking(LocalDate dateOfBooking) throws BookingNotFoundException;
    List<Booking> getByPaymentDone(boolean paymentDone) throws BookingNotFoundException;

    // Custom queries
    List<Booking> getByCostLessThan(double totalCost);
    List<Booking> getByPaymentAndHours(boolean paymentDone,int noOfHoursBooked);

    // Named query
    List<Booking> getByCarNumberAndHours(int carNumber,int noOfHoursBooked);

    // Native query
    Integer getAverageOfTotalCost();
}
