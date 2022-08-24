package com.car.model;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public enum Color {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    BLACK("Black"),
    WHITE("White"),
    YELLOW("Yellow");

    public String type;
    Color(String type) {
        this.type = type;
    }
}
