package com.user.service;

import com.user.entity.UserInfo;
import com.user.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public List<UserInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public UserInfo getHotelInfo(String userId) {
        return repository.findById(userId)
                .orElseThrow(()->new RuntimeException("User Id Not Found Exception Id :"+userId));
    }

    @Override
    public UserInfo create(UserInfo userInfo) {
        userInfo.setUserId(UUID.randomUUID().toString());
        return repository.save(userInfo);
    }
}
