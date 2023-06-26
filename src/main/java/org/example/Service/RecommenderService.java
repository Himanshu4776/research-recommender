package org.example.Service;

import org.example.Entity.RecommenderEntity;

import java.io.IOException;
import java.net.MalformedURLException;

public interface RecommenderService {
    RecommenderEntity getById(int userId);

    RecommenderEntity saveById(RecommenderEntity recommendUser);

    void fetchArticles(String link) throws IOException;
}
