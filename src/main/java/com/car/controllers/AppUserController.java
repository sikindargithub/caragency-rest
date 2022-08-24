package com.car.controllers;

import com.car.model.AppUser;
import com.car.service.IAppUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 17-05-2022
 * @Project Name : spring-rest-caragency
 */
@RestController
@RequestMapping("appuser-api")
public class AppUserController {

    private IAppUserService appUserService;
    @Autowired
    public void setAppUserService(IAppUserService appUserService) {
        this.appUserService = appUserService;
    }
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AppUserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    /**
     *
     * @param appUser the app user object
     * @return the status of the transaction
     */
    @PostMapping("/admin/add/user")
    public ResponseEntity<Void> addUser(@RequestBody AppUser appUser){
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        // encode the password before saving it to db
        String encodedPassword = passwordEncoder.encode(password);
        AppUser user = new AppUser(username,encodedPassword);
        appUserService.addUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     *
     * @param appUser the app user object
     * @return the status of the transaction
     */
    @PutMapping("/admin/update/user")
    public ResponseEntity<Void> updateUser(@RequestBody AppUser appUser){
        String username = appUser.getUsername();
        String password = appUser.getPassword();
        // encode the password before saving it to db
        String encodedPassword = passwordEncoder.encode(password);
        AppUser user = new AppUser(username,encodedPassword);
        appUserService.updateUser(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     *
     * @param userId the id of the user
     * @return the status of the transaction
     */
    @DeleteMapping("/admin/delete/user/userId/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId){

        appUserService.deleteUser(userId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","deleting one user by user id "+userId);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).build();
    }

}
