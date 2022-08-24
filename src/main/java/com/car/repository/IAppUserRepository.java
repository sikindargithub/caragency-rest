package com.car.repository;

import com.car.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {

    // returning the user by unique username
    AppUser findByUsername(String username);
}
