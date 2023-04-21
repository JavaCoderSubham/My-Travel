package com.hotel.repository;

import com.hotel.entity.HotelInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface HotelInfoRepository extends MongoRepository<HotelInfo,String> {

    Optional<HotelInfo> findByEmail(String email);

}
