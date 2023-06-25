package org.example.Dto;

import java.util.ArrayList;

public class InterestsResponseDto {
    private int userId;
    private ArrayList<String> interests;

    public InterestsResponseDto(int userId, ArrayList<String> interests) {
        this.userId = userId;
        this.interests = interests;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
