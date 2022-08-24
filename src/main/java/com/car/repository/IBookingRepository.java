package com.car.repository;

import com.car.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {

    // derived queries
    List<Booking> findByStartTime(Time startTime);
    List<Booking> findByEndTime(Time endTime);
    List<Booking> findByDateOfBooking(LocalDate dateOfBooking);
    List<Booking> findByPaymentDone(boolean paymentDone);

    // custom query
    @Query("from Booking book where book.totalCost < ?1")
    List<Booking> findByCostLessThan(double totalCost);
    @Query("from Booking book where book.paymentDone = ?1 and book.noOfHoursBooked = ?2")
    List<Booking> findByPaymentAndHours(boolean paymentDone,int noOfHoursBooked);

    // named query
    @Query(name = "getByCarNumberAndHours")
    List<Booking> findByCarNumberAndHours(int carNumber,int noOfHoursBooked);

    // native query
    @Query(value = "select avg(total_cost) from booking",nativeQuery = true)
    Integer findAverageOfTotalCost();
}
