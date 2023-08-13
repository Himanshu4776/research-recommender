package com.example.researchrecommender.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "links")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Links {
    @Id
    private String id;
    private String link;
    private String topic;
}
