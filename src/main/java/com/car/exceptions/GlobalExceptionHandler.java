package com.car.exceptions;

import com.car.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : J Sipoy Sikindar
 * @Date : 20-05-2022
 * @Project Name : Car Rental Management System
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not allowed");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Method not supported");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media type not supported");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Invalid media type");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Path variable is missing");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Missing path variable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Req param is missing");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Invalid request parameter");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Invalid data type");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Data type is invalid");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Object> handleBookingNotFound(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Booking not found");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Booking not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(CarAgencyNotFoundException.class)
    public ResponseEntity<Object> handleCarAgencyNotFound(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Car agency not found");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Car agency not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handleCarNotFound(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Car not found");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Car not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleFurnNotFound(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Customer not found");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Customer    not available");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOther(Exception ex){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Other Exception");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Other type of exception");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),error,messages);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(apiErrors);

    }

}
