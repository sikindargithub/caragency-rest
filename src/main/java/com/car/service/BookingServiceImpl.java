package com.car.service;
import com.car.exceptions.BookingNotFoundException;
import com.car.model.Booking;
import com.car.model.Customer;
import com.car.repository.IBookingRepository;
import com.car.repository.ICarRepository;
import com.car.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Time;
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
public class BookingServiceImpl implements IBookingService {

    IBookingRepository iBookingRepository;
    @Autowired
    public void setiBookingRepository(IBookingRepository iBookingRepository) {
        this.iBookingRepository = iBookingRepository;
    }
    ICarRepository iCarRepository;
    @Autowired
    public void setiCarRepository(ICarRepository iCarRepository) {
        this.iCarRepository = iCarRepository;
    }
    ICustomerRepository iCustomerRepository;
    @Autowired
    public void setiCustomerRepository(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    /**
     *
     * @param booking the object of Booking class
     * @param customerId the customer's id
     */
    @Override
    public void addBooking(Booking booking,int customerId) {

        // getting the price per hour of the car by using bookedCarNumber to calculate the total cost of booking
        double totalCost = iCarRepository.findById(booking.getBookedCarNumber()).get().getPricePerHour() * booking.getNoOfHoursBooked();
        booking.setTotalCost(totalCost);
        Customer customer = iCustomerRepository.getById(customerId);
        booking.setCustomer(customer);
        iBookingRepository.save(booking);
    }

    /**
     *
     * @param booking the object of Booking class
     */
    @Override
    public void updateBooking(Booking booking) {
        iBookingRepository.save(booking);
    }

    /**
     *
     * @param bookingId the booking id
     */
    @Override
    public void deleteById(int bookingId) {
        iBookingRepository.deleteById(bookingId);
    }

    /**
     *
     * @param bookingId
     * @return the booking object
     * @throws BookingNotFoundException if booking is not found
     */
    @Override
    public Booking getById(int bookingId) throws BookingNotFoundException {
        return iBookingRepository.findById(bookingId).orElseThrow(()-> new BookingNotFoundException("Booking with booking id "+bookingId+" is not found.."));
    }

    /**
     *
     * @return list of all bookings
     */
    @Override
    public List<Booking> getAll() {
        return iBookingRepository.findAll().stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
    }

    /**
     *
     * @param startTime the start time of booking
     * @return list of all bookings with the given start time
     * @throws BookingNotFoundException if bookings with the given start time are not found
     */

    @Override
    public List<Booking> getByStartTime(Time startTime) throws BookingNotFoundException {
      List<Booking> bookings = iBookingRepository.findByStartTime(startTime).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
      if(bookings.isEmpty())
          throw new BookingNotFoundException("Bookings with start time "+startTime+" are not found");
      return bookings;
    }

    /**
     *
     * @param endTime the end time of booking
     * @return list of all bookings with the given end time
     * @throws BookingNotFoundException if bookings with the given end time are not found
     */
    @Override
    public List<Booking> getByEndTime(Time endTime) throws BookingNotFoundException {
        List<Booking> bookings = iBookingRepository.findByEndTime(endTime).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with end time "+endTime+" are not found");
        return bookings;
    }

    /**
     *
     * @param dateOfBooking the date of booking
     * @return list of all bookings with the given date of booking
     * @throws BookingNotFoundException if bookings with the given date of booking are not found
     */
    @Override
    public List<Booking> getByDateOfBooking(LocalDate dateOfBooking) throws BookingNotFoundException {
        List<Booking> bookings = iBookingRepository.findByDateOfBooking(dateOfBooking).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with date of booking "+dateOfBooking+" are not found");
        return bookings;
    }

    /**
     *
     * @param paymentDone the status of payment like payment done or not
     * @return list of all bookings with the given payment status
     * @throws BookingNotFoundException if bookings with the given payment status are not found
     */

    @Override
    public List<Booking> getByPaymentDone(boolean paymentDone) throws BookingNotFoundException {
        List<Booking> bookings = iBookingRepository.findByPaymentDone(paymentDone).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with payment status "+paymentDone+" are not found");
        return bookings;
    }

    /**
     *
     * @param totalCost total cost of the booking
     * @return list of all bookings whose total cost is less than the given total cost
     */
    @Override
    public List<Booking> getByCostLessThan(double totalCost) {
        List<Booking> bookings = iBookingRepository.findByCostLessThan(totalCost).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with total cost less than "+totalCost+" are not found");
        return bookings;
    }

    /**
     *
     * @param paymentDone the status of payment like payment done or not
     * @param noOfHoursBooked the no of hours that the car is booked for
     * @return list of all bookings with the given payment status and no of hours the car is booked for
     * @throws BookingNotFoundException if bookings with the given payment status and no of hours are not found
     */
    @Override
    public List<Booking> getByPaymentAndHours(boolean paymentDone, int noOfHoursBooked) {
        List<Booking> bookings = iBookingRepository.findByPaymentAndHours(paymentDone,noOfHoursBooked).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with payment status "+paymentDone+" and no of days booked "+noOfHoursBooked+" are not found");
        return bookings;
    }

    /**
     *
     * @param carNumber the car number
     * @param noOfHoursBooked the no of hours that the car is booked for
     * @return list of all bookings with the given car number and no of hours the car is booked for
     * @throws BookingNotFoundException if bookings with the given car number and no of hours are not found
     */
    @Override
    public List<Booking> getByCarNumberAndHours(int carNumber, int noOfHoursBooked) {
        List<Booking> bookings = iBookingRepository.findByCarNumberAndHours(carNumber,noOfHoursBooked).stream().sorted(Comparator.comparing(Booking::getBookingId)).collect(Collectors.toList());
        if(bookings.isEmpty())
            throw new BookingNotFoundException("Bookings with car number "+carNumber+" and no of hours booked "+noOfHoursBooked+" are not found");
        return bookings;
    }

    /**
     *
     * @return the average of total costs of all bookings
     */
    @Override
    public Integer getAverageOfTotalCost() {
        return iBookingRepository.findAverageOfTotalCost();
    }
}
