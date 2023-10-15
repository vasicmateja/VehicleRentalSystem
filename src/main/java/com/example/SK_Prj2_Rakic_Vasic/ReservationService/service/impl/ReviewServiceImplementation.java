package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.impl;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Review;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.review.ReviewDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.ReservationMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.ReviewMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.ReviewRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ReviewServiceImplementation implements ReviewService {
    private final ReviewRepository reviewRepository;
    private ReservationMapper reservationMapper;
    private ReviewMapper reviewMapper;
    private JmsTemplate jmsTemplate;
    private String reviewDestination;
    private MessageHelper messageHelper;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, ReservationMapper reservationMapper, ReviewMapper reviewMapper, JmsTemplate jmsTemplate,
                                       @Value("${destination.review}") String reviewDestination, MessageHelper messageHelper) {
        this.reviewRepository = reviewRepository;
        this.reservationMapper = reservationMapper;
        this.reviewMapper = reviewMapper;
        this.jmsTemplate = jmsTemplate;
        this.reviewDestination = reviewDestination;
        this.messageHelper = messageHelper;
    }

    @Override
    public ReviewDto findReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()->new NotFoundException("Review ciji je id:" + id + "nije pronadjen"));

        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public ReviewDto createReview(ReviewCreateDto reviewCreateDto) {
        Review review = reviewMapper.reviewCreateDtoToReview(reviewCreateDto);
        reviewRepository.save(review);

        //TODO DODAJ KAD SREDIS EUREKU
       // jmsTemplate.convertAndSend(reviewDestination, messageHelper.createTextMessage(reviewCreateDto));

        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto) {
        Review review = reviewRepository.findById(reviewDto.getId()).orElseThrow(()->new NotFoundException("Review ciji je id:" + reviewDto.getId() + "nije pronadjen"));
        review.setCompany(review.getCompany());
        review.setUserId(review.getUserId());
        review.setComment(review.getComment());
        review.setGrade(reviewDto.getGrade());

        reviewRepository.save(review);
        return reviewMapper.reviewToReviewDto(review);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(()->new NotFoundException("Review ciji je id:" + id + "nije pronadjen"));

        reviewRepository.delete(review);
    }
}
