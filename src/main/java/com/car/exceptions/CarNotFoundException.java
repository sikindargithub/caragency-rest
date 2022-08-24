package com.car.exceptions;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException() {
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
