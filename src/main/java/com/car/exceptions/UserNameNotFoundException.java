/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 19-05-2022
 * @Time : 22:19
 * @Project Name : spring-rest-caragency
 */
package com.car.exceptions;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public class UserNameNotFoundException extends RuntimeException {
    public UserNameNotFoundException() {
        super();
    }

    public UserNameNotFoundException(String message) {
        super(message);
    }
}
