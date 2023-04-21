package com.user.service;


import com.user.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getAll();
    UserInfo getHotelInfo(String userId);
    UserInfo create(UserInfo userInfo);
}
