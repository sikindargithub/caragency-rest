/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 17-05-2022
 * @Time : 16:44
 * @Project Name : spring-rest-caragency
 */
package com.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "address_generator",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_generator",sequenceName = "address_sequence",initialValue = 300,allocationSize = 1)
    private Integer addressId;
    @Column(length = 30,unique = true)
    private String flatNumber;
    @Column(length = 30)
    private String streetName;
    private String city;
    @Column(length = 30)
    private String state;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private CarAgency carAgency;


    public Address(String flatNumber, String streetName, String city, String state) {
        this.flatNumber = flatNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
    }
}
