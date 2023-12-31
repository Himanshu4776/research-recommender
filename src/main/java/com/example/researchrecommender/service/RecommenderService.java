package com.example.researchrecommender.service;

import com.example.researchrecommender.dto.LinksResponse;
import com.example.researchrecommender.dto.UpdateLinkRequest;
import com.example.researchrecommender.dto.UserResponse;
import com.example.researchrecommender.model.Links;
import com.example.researchrecommender.repository.LinksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

import static com.example.researchrecommender.constants.Constants.COMMA_DELIMITER;
import static com.example.researchrecommender.utils.Utils.extractKeywords;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecommenderService {
    private final LinksRepository linksRepository;

    private final MongoTemplate mongoTemplate;

    @Autowired EmailSenderService emailSenderService;
    @Autowired UserService userService;

    public void createTopic(String topic, String link) {
        Links links = new Links();

        links.setTopic(topic);
        links.setLink(link);
        try {
            linksRepository.save(links);
            log.info("db for topic {} successfully created", topic);
        } catch (Exception e) {
            log.error("save operation failed");
        }
    }

     public void readFile() throws Exception {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/recommender.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        for (List<String> record : records) {
            if(Objects.equals(record.get(1), "articles_link")) continue;

            System.out.println("record line is: ");
            List<String> foundKeywords = extractKeywords(record.get(0));
            System.out.println(record.get(1));

            for(String word : foundKeywords) {
                createTopic(word, record.get(1));
            }
        }
    }

    public LinksResponse updateTopicsLink(UpdateLinkRequest updateLinkRequest) {
        Links link = linksRepository.getByTopicAndLink(updateLinkRequest.getTopic(), updateLinkRequest.getLink());
        link.setLink(updateLinkRequest.getLink());
        try {
            linksRepository.save(link);
            log.info("Updated link for {} topic", updateLinkRequest.getTopic());
        }
        catch (Exception e) {
            log.info("Error in updating link for {} topic", updateLinkRequest.getTopic());
            e.printStackTrace();
        }
        return mapToLinksResponse(link);
    }

    public List<LinksResponse> recommendTopics(List<String> topicsList) {
        List<Links> results = new ArrayList<Links>();
        for (String topic : topicsList) {
            Query query = new Query();
            query.addCriteria(Criteria.where("topic").is(topic));
            List<Links> result = mongoTemplate.find(query, Links.class);

            for (Links eachResult : result) {
                results.add(eachResult);
            }
        }
        log.info("List recommend topics have successfully fetched");
        return results.stream().map(this::mapToLinksResponse).toList();
    }

    private LinksResponse mapToLinksResponse(Links links) {
        return LinksResponse.builder().id(links.getId())
                .topic(links.getTopic())
                .link(links.getLink())
                .build();
    }

//    @Scheduled(fixedRate = 5000)
//    public void sendScheduledRecommendations() {
//        log.info("called in {}", new Date().toString());
//
//        List<UserResponse> allusers = userService.getAllUsers();
//        for(UserResponse user : allusers) {
//            List<String> userInterestedTopics = user.getTopics();
//            List<LinksResponse> recommendations = recommendTopics(userInterestedTopics);
//            try {
//                emailSenderService.sendEmail(user.getEmail(),
//                        "weekly Research paper recommendations",
//                        recommendations.toString());
//            } catch (Exception e) {
//                log.error("Error faced in sending recommendations");
//            }
//        }
//    }

    public List<LinksResponse> allLinks() {
        List<Links> results = linksRepository.findAll();
        return results.stream().map(this::mapToLinksResponse).toList();
    }

    public Set<String> allTopics() {
        Set<String> allTopicNames = new HashSet<String>();
        List<Links> results = linksRepository.findAll();
        for (Links link: results) {
            if(link.getTopic() != null && !Objects.equals(link.getTopic(), "")) {
                allTopicNames.add(link.getTopic());
            }
        }
        log.info("All topics fetched");
        return allTopicNames;
    }
}
