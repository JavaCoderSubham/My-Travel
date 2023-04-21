package com.hotel.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException() {
        super("Hotel Not Found Exception");
        log.info("HotelNotFoundException() -> | Object Created");
    }

    public HotelNotFoundException(String msg) {
        super(msg);
        log.info("HotelNotFoundException(String) -> | Object Created | Message : {}",msg);
    }
}
