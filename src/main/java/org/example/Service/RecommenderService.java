package org.example.Service;

import org.example.Entity.RecommenderEntity;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface RecommenderService {

    RecommenderEntity getById(int userId);

    RecommenderEntity saveById(RecommenderEntity recommendUser);

    void fetchArticles(String link) throws IOException;

    @Scheduled(fixedDelay = 5000)
    void runScheduler() throws InterruptedException;

    void readFile() throws FileNotFoundException;
}
