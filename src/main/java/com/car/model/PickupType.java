package com.car.model;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public enum PickupType {
    PICKUP("Pickup"),
    HOMEDELIVERY("Home Delivery");

    public String type;
    PickupType(String type){
        this.type = type;
    }
}
