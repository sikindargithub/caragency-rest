package com.car.service;

import com.car.exceptions.CustomerNotFoundException;
import com.car.model.Customer;

import java.util.List;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
public interface ICustomerService {
    
    // Crud queries
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteById(int customerId);
    Customer getById(int customerId) throws CustomerNotFoundException;
    List<Customer> getAll();
    
    // Derived methods
    List<Customer> getByGender(String gender) throws CustomerNotFoundException;
    
    // Custom queries
    List<Customer> getByName(String customerName) throws CustomerNotFoundException;
    Customer getByPhoneNo(String customerPhoneNo) throws CustomerNotFoundException;
    Customer getByAddress(String customerAddress) throws CustomerNotFoundException;

}
