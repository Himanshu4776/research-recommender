package org.example.Service;

import org.example.Entity.UserEntity;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {
    UserEntity getUser(int userId);

    UserEntity saveUser(UserEntity user);

    UserEntity updateInterest(ArrayList<String> interest);
}
