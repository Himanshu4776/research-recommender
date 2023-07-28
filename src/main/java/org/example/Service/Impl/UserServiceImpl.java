package org.example.Service.Impl;

import org.example.Dao.UserRepository;
import org.example.Entity.UserEntity;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserEntity getUser(int userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity updateInterest(ArrayList<String> interest) {
        return null;
    }


}
