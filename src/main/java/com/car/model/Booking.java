/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 17-05-2022
 * @Project Name : spring-rest-caragency
 */
package com.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQuery(name = "getByCarNumberAndHours",query = " from Booking book where book.bookedCarNumber = ?1 and noOfHoursBooked = ?2")
public class Booking {
    @Id
    @GeneratedValue(generator = "booking_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_generator",sequenceName ="booking_sequence",initialValue = 187235,allocationSize = 1)
    private Integer bookingId;
    @Column(length = 30)
    private  Time startTime;
    @Column(length = 30)
    private Time endTime;
    @Column(length = 30)
    private LocalDate dateOfBooking;
    private boolean paymentDone;  // True or False
    private int noOfHoursBooked;
    private double totalCost;
    private int bookedCarNumber;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")// This key will be added as foreign key in booking table
    private Customer customer;

    public Booking( Time startTime, Time endTime, LocalDate dateOfBooking, boolean paymentDone, int noOfHoursBooked, double totalCost, int bookedCarNumber) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfBooking = dateOfBooking;
        this.paymentDone = paymentDone;
        this.noOfHoursBooked = noOfHoursBooked;
        this.totalCost = totalCost;
        this.bookedCarNumber = bookedCarNumber;
    }

    public Booking(Time startTime, Time endTime, LocalDate dateOfBooking, boolean paymentDone, int noOfHoursBooked, int bookedCarNumber) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfBooking = dateOfBooking;
        this.paymentDone = paymentDone;
        this.noOfHoursBooked = noOfHoursBooked;
        this.bookedCarNumber = bookedCarNumber;
    }

    public Booking(Time startTime, Time endTime, LocalDate dateOfBooking, boolean paymentDone, int noOfHoursBooked, int bookedCarNumber,double totalCost, Customer customer) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateOfBooking = dateOfBooking;
        this.paymentDone = paymentDone;
        this.noOfHoursBooked = noOfHoursBooked;
        this.bookedCarNumber = bookedCarNumber;
        this.totalCost = totalCost;
        this.customer = customer;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
