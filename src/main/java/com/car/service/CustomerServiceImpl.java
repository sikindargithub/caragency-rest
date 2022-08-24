package com.car.service;

import com.car.exceptions.CustomerNotFoundException;
import com.car.model.Customer;
import com.car.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    ICustomerRepository iCustomerRepository;
    @Autowired
    public void setiCustomerRepository(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    /**
     * Method is used to save the customer
     * @param customer the customer object
     */
    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    /**
     * Method is used to update the customer
     * @param customer the customer object
     */
    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    /**
     *
     * @param customerId the customer id of the customer
     */
    @Override
    public void deleteById(int customerId) {
        iCustomerRepository.deleteById(customerId);
    }

    /**
     *
     * @param customerId the customer id of the customer
     * @return customer by using unique customer id
     * @throws CustomerNotFoundException if customer is not found
     */
    @Override
    public Customer getById(int customerId) throws CustomerNotFoundException {
        return iCustomerRepository.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Customer with customer id "+customerId+" not found..."));
    }

    /**
     *
     * @return list of all customers
     */
    @Override
    public List<Customer> getAll() {
        return iCustomerRepository.findAll();
    }

    /**
     *
     * @param gender the gender of the customer
     * @return the list of all customer with the given gender
     * @throws CustomerNotFoundException if customers with the given gender are not found
     */
    @Override
    public List<Customer> getByGender(String gender) {
        List<Customer> customers = iCustomerRepository.findByGender(gender).stream().sorted(Comparator.comparing(Customer::getCustomerName)).collect(Collectors.toList());
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers of gender "+gender+" are not found..");
        return customers;
    }

    /**
     *
     * @param customerName the name of the customer
     * @return the list of all customer with the given customer name
     * @throws CustomerNotFoundException if customers with the given customer name are not found
     */

    @Override
    public List<Customer> getByName(String customerName) {
        List<Customer> customers = iCustomerRepository.findByName(customerName).stream().sorted(Comparator.comparing(Customer::getCustomerId)).collect(Collectors.toList());
        if(customers.isEmpty())
            throw new CustomerNotFoundException("Customers of customer name "+customerName+" are not found..");
        return customers;
    }

    /**
     *
     * @param customerPhoneNo the phone no of the customer
     * @return the customer with the given phone no
     * @throws CustomerNotFoundException if customer with the given phone no is not found
     */

    @Override
    public Customer getByPhoneNo(String customerPhoneNo) {
        Customer customer =  iCustomerRepository.findByPhoneNo(customerPhoneNo);
        if(customer == null)
            throw new CustomerNotFoundException("Customer with phone no "+customerPhoneNo+" is not found..");
        return customer;
    }

    /**
     *
     * @param customerAddress the address of the customer
     * @return the customer with the given address
     * @throws CustomerNotFoundException if customer with the given address is not found
     */

    @Override
    public Customer getByAddress(String customerAddress) {
        Customer customer =  iCustomerRepository.findByAddress(customerAddress);
        if(customer == null)
            throw new CustomerNotFoundException("Customer with address "+customerAddress+" is not found..");
        return customer;
    }
}
