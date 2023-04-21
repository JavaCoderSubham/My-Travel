package com.hotel.service;

import com.hotel.entity.HotelInfo;

import java.util.List;
import java.util.Optional;

public interface HotelInfoService {

//    Get All
    List<HotelInfo> getAll();

//    Get By Id
    HotelInfo getHotelInfo(String hotelId);

//    Create
    HotelInfo create(HotelInfo hotelInfo);

//    Update
    HotelInfo update(String id, HotelInfo hotelInfo);

//    Delete
    void deleteHotel(String id);

//    Find Methods
    HotelInfo findByHotel(String email);

}
