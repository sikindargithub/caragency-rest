package com.car.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CarAgencyView {

    @Id
    private Integer registrationId;
    private String agencyName;
    private String email;
    private double rating;
    private String flatNumber;
    private String brand;
    private String carRating;
    private double pricePerHour;


}
