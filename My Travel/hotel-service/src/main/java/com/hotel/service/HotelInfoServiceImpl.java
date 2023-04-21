package com.hotel.service;

import com.hotel.entity.HotelInfo;
import com.hotel.exception.HotelNotFoundException;
import com.hotel.repository.HotelInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class HotelInfoServiceImpl implements HotelInfoService {

    @Autowired
    private HotelInfoRepository repository;

//    Get All Hotel

    @Override
    public List<HotelInfo> getAll() {
        log.info("getAll() -> | ");
        List<HotelInfo> all = repository.findAll();
        log.info("getAll() -> | List HotelInfo : {}",all);
        return all;
    }

//    Get BY Id Hotel

    @Override
    public HotelInfo getHotelInfo(String hotelId) {
        log.info("getHotelInfo(String) -> | HotelID : {}",hotelId);
        HotelInfo hotel = repository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("User Id Not Found Exception"));
        log.info("getHotelInfo(String) -> | HotelInfo : {}",hotel);
        return hotel;
    }

//    Create

    @Override
    public HotelInfo create(HotelInfo hotelInfo) {
        log.info("create(HotelInfo) -> | Hotel : {}",hotelInfo);
        hotelInfo.setHotelId(UUID.randomUUID().toString());
        log.info("create(HotelInfo) -> | After SetHotelId Hotel : {}",hotelInfo);
        HotelInfo save = repository.save(hotelInfo);
        log.info("create(HotelInfo) -> | After Save Hotel : {}",hotelInfo);
        return save;
    }

//    Update

    @Override
    public HotelInfo update(String id, HotelInfo hotelInfo) {
        log.info("update(String,HotelInfo) -> | Id : {} | HotelInfo : {}",id,hotelInfo);
        HotelInfo hotel = getHotelInfo(id);
        log.info("update(String,HotelInfo) -> | Present Id : {} | HotelInfo : {}",id,hotel);
        hotel.setHotelName(hotelInfo.getHotelName());
        hotel.setCity(hotelInfo.getCity());
        hotel.setState(hotelInfo.getState());
        hotel.setDescription(hotelInfo.getDescription());
        hotel.setImageLink(hotel.getImageLink());
        log.info("update(String,HotelInfo) -> | Set HotelInfo : {}",hotel);
        HotelInfo save = repository.save(hotel);
        log.info("update(String,HotelInfo) -> | Return HotelInfo : {}",hotel);
        return save;
    }

//    Delete

    @Override
    public void deleteHotel(String id) {
        log.info("deleteHotel(String) -> | Id : {}",id);
        repository.deleteById(id);
        log.info("deleteHotel(String) -> | Id : {} | Deleted",id);
    }

//    Finding Method

    @Override
    public HotelInfo findByHotel(String email) {
        log.info("findByHotel(String) -> | Email : {}",email);
        HotelInfo findById = repository.findByEmail(email)
                .orElseThrow(()-> new HotelNotFoundException("Hotel Not Found Exception Email : "+email));
        log.info("findByHotel(String) -> | HotelInfo : {}",findById);
        return findById;
    }

}
