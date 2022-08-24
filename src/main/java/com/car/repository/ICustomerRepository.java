package com.car.repository;

import com.car.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    // Derived methods
    List<Customer> findByGender(String gender);

    // Custom queries
    @Query("from Customer customer where customer.customerName = ?1")
    List<Customer> findByName(String customerName);
    @Query("from Customer customer where customer.customerPhoneNo = ?1")
    Customer findByPhoneNo(String customerPhoneNo);
    @Query("from Customer customer where customer.customerAddress = ?1")
    Customer findByAddress(String customerAddress);
}
