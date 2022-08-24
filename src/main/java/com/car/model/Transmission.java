package com.car.model;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public enum Transmission {
    MANUAL("Manual"),
    AUTOMATIC("Automatic");

    public String type;
    Transmission(String type){
        this.type = type;
    }
}
