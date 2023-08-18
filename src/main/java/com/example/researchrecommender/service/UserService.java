package com.example.researchrecommender.service;

import com.example.researchrecommender.dto.UserLogin;
import com.example.researchrecommender.dto.UserRequest;
import com.example.researchrecommender.dto.UserResponse;
import com.example.researchrecommender.dto.UserUpdateRequest;
import com.example.researchrecommender.model.User;
import com.example.researchrecommender.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserRequest userRequest) {
        User user = User.builder().name(userRequest.getName())
                .password(userRequest.getPassword())
                .topics(userRequest.getTopics())
                .email(userRequest.getEmail())
                .build();

        userRepository.save(user);

        log.info("User {} saved successfully", user.getId());
    }

    public List<UserResponse> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(this::mapToUserResponse).toList();
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder().
                id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .topics(user.getTopics())
                .build();
    }

    public UserResponse updateUserTopics(UserUpdateRequest userUpdateRequest) {
        User userFetched = userRepository.getByUserId(userUpdateRequest.getId());

        userFetched.setTopics(userUpdateRequest.getTopics());
        try {
            userRepository.save(userFetched);
            log.info("User {} updated successfully", userFetched.getId());
        }
        catch (Exception e) {
            log.error("Failed to update user {} topics", userUpdateRequest.getId());
        }
        return UserResponse.builder().id(userFetched.getId())
                .name(userFetched.getName())
                .email(userFetched.getEmail())
                .topics(userFetched.getTopics())
                .build();
    }

    public Boolean userLoginService(UserLogin userLogin) {
        try {
            User user = userRepository.getByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
            return user != null;
        } catch (Exception e) {
            return false;
        }
    }

    public String updatePassword(UserLogin userLogin) {
        try {
            User user = userRepository.getByEmail(userLogin.getEmail());
            if(user != null) {
                user.setPassword(userLogin.getPassword());
                return "SUCCESS";
            }
            return "PASSWORD_UPDATE_FAILED";
        } catch (Exception e) {
            return "INCORRECT_EMAIL_ENTERED";
        }
    }
}
