package com.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class HotelInfo {

    @Id
    private String hotelId;
    private String hotelName;
    private String mobileNumber;
    private String city;
    private String state;
    private String description;
    private String imageLink;
    @Indexed(unique = true)
    private String email;
    private String password;

}
