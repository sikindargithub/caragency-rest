package com.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(generator = "customer_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "customer_generator",sequenceName = "customer_sequence",initialValue = 500,allocationSize = 1)
    private Integer customerId;
    @Column(length = 40)
    private String customerName;
    @Column(length = 20)
    private String gender;
    private long customerPhoneNo;
    @Column(length = 90)
    private String customerAddress;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "customer")
    private List<Booking> bookings;

    public Customer(String customerName, String gender, long customerPhoneNo, String customerAddress) {
        this.customerName = customerName;
        this.gender = gender;
        this.customerPhoneNo = customerPhoneNo;
        this.customerAddress = customerAddress;
    }

    public Customer(Integer customerId, String customerName, String gender, long customerPhoneNo, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.gender = gender;
        this.customerPhoneNo = customerPhoneNo;
        this.customerAddress = customerAddress;
    }
}
