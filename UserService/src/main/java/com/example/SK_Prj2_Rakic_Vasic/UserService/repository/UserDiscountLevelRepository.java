package com.example.SK_Prj2_Rakic_Vasic.UserService.repository;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.UserDiscountLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDiscountLevelRepository extends JpaRepository<UserDiscountLevel, Long> {
}
