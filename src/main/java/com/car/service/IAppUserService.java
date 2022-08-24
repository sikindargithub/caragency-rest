package com.car.service;

import com.car.model.AppUser;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public interface IAppUserService {

    void addUser(AppUser user);
    void updateUser(AppUser user);
    void deleteUser(int userId);
}
