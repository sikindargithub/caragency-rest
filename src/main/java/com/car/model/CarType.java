package com.car.model;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public enum CarType {
    SUV("Suv"),
    SEDAN("Sedan"),
    HATCHBACK("Hatchback"),
    LUXURY("Luxury");

    public String type;
    CarType(String type){
        this.type = type;
    }
}
