package com.example.researchrecommender.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicsRequest {
    private List<String> topicsList;
}