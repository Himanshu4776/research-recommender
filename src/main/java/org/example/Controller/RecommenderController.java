package org.example.Controller;

import org.example.Dto.InterestRequestDto;
import org.example.Dto.InterestsResponseDto;
import org.example.Entity.RecommenderEntity;
import org.example.Service.RecommenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/recommend")
public class RecommenderController {
    private RecommenderService recommenderService;

    @GetMapping("/getInterests/{userId}")
    public ResponseEntity<InterestsResponseDto> GetInterests(@PathVariable("userId") int userId) {
        RecommenderEntity interestResponse = recommenderService.getById(userId);
        InterestsResponseDto interestResponseResult = new InterestsResponseDto(0, new ArrayList<>());
        interestResponseResult.setInterests(interestResponse.getInterests());
        interestResponseResult.setUserId(interestResponse.getId());

        return ResponseEntity.ok(interestResponseResult);
    }

    @PatchMapping("/updateInterest/{userId}")
    public ResponseEntity<Boolean> updateInterest(@RequestBody InterestRequestDto interestRequest) {
        try {
            RecommenderEntity entity = recommenderService.getById(interestRequest.getUserId());
            entity.setInterests(interestRequest.getInterests());

            try {
                recommenderService.saveById(entity);
            } catch (Exception e) {
                return (ResponseEntity<Boolean>) ResponseEntity.internalServerError();
            }
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }
}
