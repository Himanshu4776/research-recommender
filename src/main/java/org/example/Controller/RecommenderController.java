package org.example.Controller;

import org.example.Dto.InterestsResponseDto;
import org.example.Service.RecommenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommend")
public class RecommenderController {
    private RecommenderService recommenderService;

    @GetMapping("/getInterests/{userId}")
    public ResponseEntity<InterestsResponseDto> GetInterests(@PathVariable("userId") int userId) {
//        InterestsResponseDto interestResponse = recommenderService
        return ResponseEntity.ok(null);
    }
}
