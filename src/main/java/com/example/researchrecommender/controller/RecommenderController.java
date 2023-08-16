package com.example.researchrecommender.controller;

import com.example.researchrecommender.dto.LinksResponse;
import com.example.researchrecommender.dto.UpdateLinkRequest;
import com.example.researchrecommender.service.RecommenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommenderController {

    private final RecommenderService recommendService;

    @GetMapping("/createDb")
    @ResponseStatus(HttpStatus.OK)
    public void createDb() throws Exception {
        try {
            recommendService.readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/topics")
    @ResponseStatus(HttpStatus.OK)
    public List<LinksResponse> recommendedTopics(List<String> topicsList) {
        return recommendService.recommendTopics(topicsList);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LinksResponse updateTopicsLink(UpdateLinkRequest updateLinkRequest) throws Exception {
        return recommendService.updateTopicsLink(updateLinkRequest);
    }

    @GetMapping("/topics")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> fetchAllTopics() {
        return recommendService.allTopics();
    }
}
