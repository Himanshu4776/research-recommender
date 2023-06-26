package org.example.Service.Impl;

import org.example.Dao.RecommenderRepository;
import org.example.Entity.RecommenderEntity;
import org.example.Service.RecommenderService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

    @Override
    public void fetchArticles(String link) throws IOException {
        try {
            link = "https://ieeexplore.ieee.org/xpl/topAccessedArticles.jsp?punumber=6287639";

            Document document =  Jsoup.connect(link).get();
            Elements articles = document.select(".List-first-container");
            for (Element article: articles) {
                Elements linkElement = article.select("a");
                if(linkElement != null) {
                    String articleName = linkElement.text();
                    String articleLink = linkElement.attr("href");

                    System.out.println("name: " + articleName);
                    System.out.println("link: " + articleLink);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}