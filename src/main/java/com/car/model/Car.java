package com.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
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
public class Car {
    @Id
    private Integer carNumber;
    @Column(length = 30)
    private String brand;
    @Column(length=30)
    private String model;
    private int mileage;
    private String color; // Red,Blue,Black,White,Green,Yellow
    private int noOfSeats;
    @Column(length = 30)
    private String carType; //Hatchback,Sedan,SUV,Luxury
    private double pricePerHour;
    @Column(length = 30)
    private String fuelType; // Petrol or Diesel
    @Column(length=30)
    private String transmission;
    private boolean insuranced;
    private double kmsDriven;
    @Column(length = 30)
    private String pickupType;
    private double carRating;
    @Column(length=70)
    private String carImg;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER) //,mappedBy = "car"
    private Set<Booking> bookings;

//    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registration_id")
    private CarAgency carAgency;


    public Car(Integer carNumber, String brand, String model, int mileage, String color, int noOfSeats, String carType, double pricePerHour, String fuelType, String transmission, boolean insuranced, double kmsDriven, String pickupType, double carRating) {
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.color = color;
        this.noOfSeats = noOfSeats;
        this.carType = carType;
        this.pricePerHour = pricePerHour;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.insuranced = insuranced;
        this.kmsDriven = kmsDriven;
        this.pickupType = pickupType;
        this.carRating = carRating;
    }

    public CarAgency getCarAgency() {
        return carAgency;
    }

    public void setCarAgency(CarAgency carAgency) {
        this.carAgency = carAgency;
    }
}
