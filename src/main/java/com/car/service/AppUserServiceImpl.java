/**
 * @Author : Sipoy Sikindar Jillepally
 * @Date : 19-05-2022
 * @Time : 22:07
 * @Project Name : spring-rest-caragency
 */
package com.car.service;

import com.car.model.AppUser;
import com.car.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */

@Service
public class AppUserServiceImpl implements UserDetailsService ,IAppUserService{
    IAppUserRepository iAppUserRepository;
    @Autowired
    public void setiAppUserRepository(IAppUserRepository iAppUserRepository) {
        this.iAppUserRepository = iAppUserRepository;
    }

    /**
     *
     * @param user the object of AppUser class
     */
    @Override
    public void addUser(AppUser user) {
        iAppUserRepository.save(user);
    }

    /**
     *
     * @param user the object of AppUser class
     */
    @Override
    public void updateUser(AppUser user) {
        iAppUserRepository.save(user);
    }

    /**
     *
     * @param userId the user id of the user
     */
    @Override
    public void deleteUser(int userId) {
        iAppUserRepository.deleteById(userId);
    }

    /**
     *
     * @param username the username of the user
     * @return the user by verifying unique username
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Getting the user from the database
        AppUser appUser = iAppUserRepository.findByUsername(username);
        if(appUser==null)
            throw new UsernameNotFoundException("Invalid username");

        // Getting username and password
        String nusername = appUser.getUsername();
        String password  = appUser.getPassword();

        // Setting roles for the user
        GrantedAuthority authority1 = new SimpleGrantedAuthority("USER");
        GrantedAuthority authority2 = new SimpleGrantedAuthority("ADMIN");

        // Creating a new user object using UserDetails interface
        UserDetails user = new User(nusername,password, Arrays.asList(authority1,authority2));

        return user;
    }


}
