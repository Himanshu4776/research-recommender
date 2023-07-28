package org.example.Controller;

import org.example.Dto.UserResponseDto;
import org.example.Entity.UserEntity;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommend")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> GetUsers(@PathVariable("userId") int userId) {
        UserEntity user = userService.getUser(userId);
        UserResponseDto userResponseResult = new UserResponseDto();
        userResponseResult.setTopics(user.getTopics());
        userResponseResult.setUserId(user.getUserId());

        return ResponseEntity.ok(userResponseResult);
    }

    @PostMapping("/users")
    public ResponseEntity<UserEntity> setUser(UserEntity user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        }
        catch (Exception e) {
            return (ResponseEntity<UserEntity>) ResponseEntity.badRequest();
        }
    }

    @PatchMapping("users/{userId}")
    public ResponseEntity<UserEntity> updateUser(UserEntity user) {
        try {
            userService.updateInterest(user.getTopics());
            return ResponseEntity.ok(user);
        }
        catch (Exception e) {
            return (ResponseEntity<UserEntity>) ResponseEntity.badRequest();
        }
    }
}
