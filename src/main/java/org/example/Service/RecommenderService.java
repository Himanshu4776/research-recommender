package org.example.Service;

import org.example.Entity.RecommenderEntity;

public interface RecommenderService {
    RecommenderEntity getById(int userId);

    RecommenderEntity saveById(RecommenderEntity recommendUser);
}
