package com.car.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
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
@AllArgsConstructor
@ToString
@Table(name = "caragency")
public class CarAgency {
    @Id
    private Integer registrationId;
    @Column(length = 30)
    private String agencyName;
    @Column(length = 30)
    private String email;
    @Column(length = 30)
    private long agencyContactNo;
    @Column(length = 30)
    private String city;
    private double rating;
    private LocalDate establishedDate;
    private int experience;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "carAgency")
    private Set<Car> cars;


}
