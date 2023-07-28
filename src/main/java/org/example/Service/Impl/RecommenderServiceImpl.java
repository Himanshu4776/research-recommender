package org.example.Service.Impl;

import com.cloudinary.Cloudinary;
import org.example.Constants.Constants;
import org.example.Dao.RecommenderRepository;
import org.example.Entity.RecommenderEntity;
import org.example.Service.RecommenderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import static org.example.Constants.Constants.COMMA_DELIMITER;

@Service
public class RecommenderServiceImpl implements RecommenderService {

//    @Autowired RecommenderRepository recommenderRepository;
    private final RecommenderRepository recommenderRepository;

    @Autowired
    private Constants constants;

    private final Cloudinary cloudinary;

    @Autowired
    public RecommenderServiceImpl(RecommenderRepository recommenderRepository, Cloudinary cloudinary, Cloudinary cloudinary1) {
        super();
        this.recommenderRepository = recommenderRepository;
//        this.constants = constants;
        this.cloudinary = cloudinary1;
    }

    @Override
    public RecommenderEntity getById(int userId) {
        return recommenderRepository.getOne(userId);
    }

    @Override
    public RecommenderEntity saveById(RecommenderEntity recommendUser) {
        return recommenderRepository.saveAndFlush(recommendUser);
    }

    @Override
    public void fetchArticles(String link) throws IOException {
        Cloudinary cloudinary = new Cloudinary(Cloudinary.asMap(
        "cloud_name", "dsz4woagj",
        "api_key", "571261715518268",
        "api_secret", "0skWi4bPTR5cSSOXu-6m7ilhDRY"));
    }

    @Override
    public void runScheduler() throws InterruptedException {
        Logger.getLogger("logging info").info("right now day is " + LocalDateTime.now().getDayOfWeek());

        Thread.sleep(10000);
    }

    @Override
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
            System.out.println("record line is: ");
            for (String value : record) {
                System.out.print(value);
                System.out.println();
            }
//            boolean delimiterFound = false;
//            for (String value : record) {
//                if(value == ",") {
//                    delimiterFound = true;
//                }
//                if(delimiterFound && value != ",") {
//
//                }
//            }
            System.out.println();
            System.out.print(record.size());
//            break;
        }
    }
}