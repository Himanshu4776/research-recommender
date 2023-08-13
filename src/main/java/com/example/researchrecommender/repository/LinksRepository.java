package com.example.researchrecommender.repository;

import com.example.researchrecommender.model.Links;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LinksRepository extends MongoRepository<Links, String> {

    @Query("{topic: ?0, link: ?1}")
    Links getByTopicAndLink(String topic, String link);
}
