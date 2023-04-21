package com.hotel.exception;

import com.hotel.entity.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
        log.error("GlobalExceptionHandler() -> | ");
    }

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorMessage> hotelnotFoundException(HotelNotFoundException ex) {
        log.error("hotelnotFoundException(HotelNotFoundException) -> | HotelNotFoundException : {}",ex);
        log.error("hotelnotFoundException(HotelNotFoundException) -> | ErrorMessage : {}",ex.getMessage());
        ErrorMessage error = new ErrorMessage(ex.getMessage(), LocalDateTime.now().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

}
