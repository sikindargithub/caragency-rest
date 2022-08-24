package com.car.service;

import com.car.exceptions.CarAgencyNotFoundException;
import com.car.model.CarAgency;
import com.car.model.CarAgencyView;
import com.car.repository.ICarAgencyRepository;
import com.car.repository.ICarAgencyViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */
@Service
public class CarAgencyerviceImpl implements ICarAgencyService {

    ICarAgencyRepository iCarAgencyRepository;
    @Autowired
    public void setiCarAgencyRepository(ICarAgencyRepository iCarAgencyRepository) {
        this.iCarAgencyRepository = iCarAgencyRepository;
    }
    ICarAgencyViewRepository iCarAgencyViewRepository;
    @Autowired
    public void setiCarAgencyViewRepository(ICarAgencyViewRepository iCarAgencyViewRepository) {
        this.iCarAgencyViewRepository = iCarAgencyViewRepository;
    }

    /**
     * Method  is used to save the car agency
     * @param carAgency the car agency object
     */
    @Override
    public void addCarAgency(CarAgency carAgency) {
        iCarAgencyRepository.save(carAgency);
    }

    /**
     * Method is used to update the car agency
     * @param carAgency the car agency object
     */

    @Override
    public void updateCarAgency(CarAgency carAgency) {
        iCarAgencyRepository.save(carAgency);
    }

    /**
     * Method is used to delete the car agency using registration id
     * @param registrationId the registration id of the car agency
     */
    @Override
    public void deleteById(int registrationId) {
        iCarAgencyRepository.deleteById(registrationId);
    }

    /**
     * Method is used to get the car agency by registration id
     * @param registrationId the registration of the car agency
     * @return the car agency object by using unique registration id
     */
    @Override
    public CarAgency getById(int registrationId) {
        return iCarAgencyRepository.findById(registrationId).orElseThrow(()->new CarAgencyNotFoundException("Car agency with "+registrationId+" is not found.."));
    }

    /**
     *
     * @return list of all car agencies
     */
    @Override
    public List<CarAgency> getAll() {
        return iCarAgencyRepository.findAll().stream().sorted(Comparator.comparing(CarAgency::getAgencyName)).collect(Collectors.toList());
    }

    /**
     *
     * @param agencyName the name of agency
     * @return list of all agencies with the given agency name
     * @throws CarAgencyNotFoundException if car agencies with the given agency name are not found
     */
    @Override
    public List<CarAgency> getByAgencyName(String agencyName) {
        List<CarAgency> carAgencyList = iCarAgencyRepository.findByAgencyName(agencyName).stream().sorted(Comparator.comparing(CarAgency::getRegistrationId)).collect(Collectors.toList());
        if(carAgencyList.isEmpty())
            throw new CarAgencyNotFoundException("Car agencies with name "+agencyName+" are not found..");
        return carAgencyList;
    }

    /**
     *
     * @param rating the rating of car agency
     * @return list of all agencies with the given rating
     * @throws CarAgencyNotFoundException if car agencies with the given rating are not found
     */
    @Override
    public List<CarAgency> getByRating(double rating) {
        List<CarAgency> carAgencyList = iCarAgencyRepository.findByRating(rating).stream().sorted(Comparator.comparing(CarAgency::getAgencyName)).collect(Collectors.toList());
        if(carAgencyList.isEmpty())
            throw new CarAgencyNotFoundException("Car agencies with rating "+rating+" are not found..");
        return carAgencyList;
    }

    /**
     *
     * @param experience the experience of the car agency
     * @return list of all agencies with the given experience
     * @throws CarAgencyNotFoundException if car agencies with the given experience are not found
     */
    @Override
    public List<CarAgency> getByExperience(int experience) {
        List<CarAgency> carAgencyList = iCarAgencyRepository.findByExperience(experience).stream().sorted(Comparator.comparing(CarAgency::getAgencyName)).collect(Collectors.toList());
        if(carAgencyList.isEmpty())
            throw new CarAgencyNotFoundException("Car agencies with experience "+experience+" are not found..");
        return carAgencyList;
    }

    /**
     *
     * @param establishedDate the establishment date of the car agency
     * @return list of all agencies with the given establishment date
     * @throws CarAgencyNotFoundException if car agencies with the given established date are not found
     */
    @Override
    public List<CarAgency> getByDate(LocalDate establishedDate) {
        List<CarAgency> carAgencyList = iCarAgencyRepository.findByDate(establishedDate).stream().sorted(Comparator.comparing(CarAgency::getAgencyName)).collect(Collectors.toList());
        if(carAgencyList.isEmpty())
            throw new CarAgencyNotFoundException("Car agencies with established date "+establishedDate+" are not found..");
        return carAgencyList;
    }

    /**
     *
     * @return list of all agencies which consist car agency fields along with  some fields of dependent classes
     */
    @Override
    public List<CarAgencyView> getAllCarAgencies() {
        List<CarAgencyView> carAgencyViewList = iCarAgencyViewRepository.findAll().stream().sorted(Comparator.comparing(CarAgencyView::getAgencyName)).collect(Collectors.toList());
        if(carAgencyViewList.isEmpty())
            throw new CarAgencyNotFoundException("Car agencies are not found..");
        return carAgencyViewList;
    }

}
