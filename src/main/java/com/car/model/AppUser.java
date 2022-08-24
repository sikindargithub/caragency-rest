/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 19-05-2022
 * @Time : 22:02
 * @Project Name : spring-rest-caragency
 */
package com.car.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Column(unique = true,length = 30)
    private String username;
    private String password;
    @Id
    @GeneratedValue
    private Integer userId;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
