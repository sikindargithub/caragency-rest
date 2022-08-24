/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 17-05-2022
 * @Time : 19:52
 * @Project Name : spring-rest-caragency
 */
package com.car.controllers;

import com.car.model.Customer;
import com.car.service.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@RestController
@RequestMapping("/customer-api")
public class CustomerController {

    ICustomerService iCustomerService;
    @Autowired
    public void setiCustomerService(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    private static  final Logger LOGGER = LogManager.getLogger(CustomerController.class);


    /**
     *
     * @param customer the customer object
     * @return the status of the transaction
     */

    @PostMapping("/customers")
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer){
        iCustomerService.addCustomer(customer);
        return  ResponseEntity.status(HttpStatus.CREATED).build();

    }

    /**
     *
     * @param customer the customer object
     * @return the status of the transaction
     */
    @PutMapping("/cusotmers")
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer){
        iCustomerService.updateCustomer(customer);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

    }

    /**
     *
     * @param customerId the id of the customer
     * @return the status of the transaction
     */
    @DeleteMapping("/customers/customerId/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") int customerId){

        iCustomerService.deleteById(customerId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","deleting one customer by id "+customerId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();

    }

    /**
     *
     * @return the list of all the customers
     */
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> showAll(){
        LOGGER.info("Getting list of all customers..");
        LOGGER.error("DB connection is failed..");
        LOGGER.warn("Unknown customer is logged in..");


        List<Customer> customers = iCustomerService.getAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","getting all customers");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(customers);

    }
}
