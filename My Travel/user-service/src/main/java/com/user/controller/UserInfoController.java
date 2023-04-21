package com.user.controller;

import com.user.entity.UserInfo;
import com.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @GetMapping("/getAll")
    public List<UserInfo> getAll() {
        return service.getAll();
    }

    @GetMapping("/getUserInfo/{userId}")
    public UserInfo getUserInfo(@PathVariable String userId) {
        return service.getHotelInfo(userId);
    }

    @PostMapping("/create")
    public UserInfo create(@RequestBody UserInfo userInfo) {
        return service.create(userInfo);
    }

}
