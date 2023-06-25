package org.example.Service.Impl;

import org.example.Dao.RecommenderRepository;
import org.example.Entity.RecommenderEntity;
import org.example.Service.RecommenderService;
import org.springframework.beans.factory.annotation.Autowired;

public class RecommenderServiceImpl implements RecommenderService {
    @Autowired RecommenderRepository recommenderRepository;

    @Override
    public RecommenderEntity getById(int userId) {
        return recommenderRepository.getById(userId);
    }

    @Override
    public RecommenderEntity saveById(RecommenderEntity recommendUser) {
        return recommenderRepository.saveAndFlush(recommendUser);
    }
}