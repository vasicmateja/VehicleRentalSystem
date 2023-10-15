package com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Review;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    private CompanyRepository companyRepository;

    public ReviewMapper(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ReviewDto reviewToReviewDto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setComment(review.getComment());
        reviewDto.setGrade(review.getGrade());
        reviewDto.setCompany(review.getCompany().getName());
        return reviewDto;
    }

    public Review reviewCreateDtoToReview(ReviewCreateDto reviewCreateDto) {
        Review review = new Review();
        review.setGrade(reviewCreateDto.getGrade());
        review.setComment(reviewCreateDto.getComment());
        review.setCompany(companyRepository.findCompanyByName(reviewCreateDto.getCompany()));
        review.setUserId(reviewCreateDto.getUserId());
        return review;
    }
}
