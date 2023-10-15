package com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resevation/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewCreateDto reviewCreateDto) {
        return new ResponseEntity<>(reviewService.createReview(reviewCreateDto), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ReviewDto> updateReview(@RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.updateReview(reviewDto), HttpStatus.OK);
    }
}
