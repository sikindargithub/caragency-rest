package com.car.exceptions;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public class CarAgencyNotFoundException extends RuntimeException{
    public CarAgencyNotFoundException() {
        super();
    }

    public CarAgencyNotFoundException(String message) {
        super(message);
    }
}
