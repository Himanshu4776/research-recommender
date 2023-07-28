package org.example.Dto;

import java.util.ArrayList;

public class UserResponseDto {
    int userId;
    private String userName;
    private ArrayList<String> topics;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public UserResponseDto(int userId, String userName, ArrayList<String> topics) {
        this.userId = userId;
        this.userName = userName;
        this.topics = topics;
    }

    public UserResponseDto() {
    }
}
