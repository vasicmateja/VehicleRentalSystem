package com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Review findReviewById(Long id);

    Review findByUserId(Long id);

    List<Review> findAll();
}
