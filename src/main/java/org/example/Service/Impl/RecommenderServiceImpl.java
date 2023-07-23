package org.example.Service.Impl;

import com.cloudinary.Cloudinary;
import org.example.Constants.Constants;
import org.example.Dao.RecommenderRepository;
import org.example.Entity.RecommenderEntity;
import org.example.Service.RecommenderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

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
    public void readFile() throws FileNotFoundException {
//        try (BufferedInputStream in = new BufferedInputStream(new URL(constants.FILE_URL).openStream());
//             FileOutputStream fileOutputStream = new FileOutputStream("recommender.csv")) {
//            byte dataBuffer[] = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//                fileOutputStream.write(dataBuffer, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            // handle exception
//            e.printStackTrace();
//        }

        int r = 0;
        try {
            File file = new File("src/main/resources/recommender.csv");
            FileInputStream fis = new FileInputStream(file);
            while( (r = fis.read()) != -1) {
                System.out.println((char) r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}