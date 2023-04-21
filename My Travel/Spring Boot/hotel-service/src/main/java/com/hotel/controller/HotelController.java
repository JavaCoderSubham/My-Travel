package com.hotel.controller;


import com.hotel.entity.HotelInfo;
import com.hotel.service.HotelInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelInfoService service;

//    GetMapping

    @GetMapping("/getAll")
    public List<HotelInfo> getAll() {
        log.info("============= Get All Method Start =============");
        log.info("getAll() -> | ");
        List<HotelInfo> all = service.getAll();
        log.info("getAll() -> | List Hotel : {}",all);
        log.info("============= Get All Method End =============");
        return all;
    }

    @GetMapping("/getHotelInfo/{hotelId}")
    public HotelInfo getHotelInfo(@PathVariable String hotelId) {
        log.info("============= get HotelInfo Method Start =============");
        log.info("getHotelInfo(String) -> | HotelId : {}",hotelId);
        HotelInfo hotel = service.getHotelInfo(hotelId);
        log.info("getHotelInfo(String) -> | Hotel : {}",hotel);
        log.info("============= get HotelInfo Method End =============");
        return hotel;
    }

    @GetMapping("/findEmail/{email}")
    public HotelInfo findByEmail(@PathVariable String email) {
        log.info("============= Find By Email Method Start =============");
        log.info("findByEmail(String) -> | Email : {}",email);
        HotelInfo hotel = service.findByHotel(email);
        log.info("findByEmail(String) -> | HotelInfo : {}",hotel);
        log.info("============= Find By Email Method End =============");
        return hotel;
    }

//    PostMapping

    @PostMapping("/create")
    public HotelInfo create(@RequestBody HotelInfo hotelInfo) {
        log.info("============= Create Method Start =============");
        log.info("create(HotelInfo) -> | Hotel : {}",hotelInfo);
        HotelInfo hotelInfo1 = service.create(hotelInfo);
        log.info("create(HotelInfo) -> | After Return Hotel : {}",hotelInfo1);
        log.info("============= Create Method End =============");
        return hotelInfo1;
    }

//    PutMapping

    @PutMapping("/update/{Id}")
    public HotelInfo update(@PathVariable String id,@RequestBody HotelInfo hotel) {
        log.info("============= Update Method Start =============");
        log.info("update(String,HotelInfo) -> | Id : {} | HotelInfo : {}",id,hotel);
        HotelInfo update = service.update(id, hotel);
        log.info("update(String,HotelInfo) -> | After Save HotelInfo : {}",hotel);
        log.info("============= Update Method End =============");
        return update;
    }

//    DeleteMapping

    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable String id) {
        log.info("============= Delete Hotel Method Start =============");
        log.info("deleteHotel(String) -> | Id : {}",id);
        if(checkIdIsPresent(id)) {
            log.info("deleteHotel(String) -> | Present Id : {}",id);
            service.deleteHotel(id);
            return "Delete Hotel id:"+id;
        }
        log.info("deleteHotel(String) -> | Id : {} | Not Present",id);
        log.info("============= Delete Hotel Method End =============");
        return "Sorry Id Not Present";
    }

//    Private Methods

    private boolean checkIdIsPresent(String hotelId) {
        log.info("checkIdIsPresent(String) -> | Hotel Id : {}",hotelId);
        HotelInfo hotel = getHotelInfo(hotelId);
        log.info("checkIdIsPresent(String) -> | Hotel : {}",hotel);
        return hotel != null;
    }

}
