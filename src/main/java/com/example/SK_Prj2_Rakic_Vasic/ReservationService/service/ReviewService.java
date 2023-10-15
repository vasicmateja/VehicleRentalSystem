package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewDto;

public interface ReviewService {
    ReviewDto findReview(Long id);

    ReviewDto createReview(ReviewCreateDto reviewCreateDto);

    ReviewDto updateReview(ReviewDto reviewDto);

    void deleteReview(Long id);
}
