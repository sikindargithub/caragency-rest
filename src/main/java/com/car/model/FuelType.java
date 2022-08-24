package com.car.model;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public enum FuelType {
    PETROL("Petrol"),
    DIESEL("Diesel");

    public String type;
    FuelType(String type){
        this.type = type;
    }
}
