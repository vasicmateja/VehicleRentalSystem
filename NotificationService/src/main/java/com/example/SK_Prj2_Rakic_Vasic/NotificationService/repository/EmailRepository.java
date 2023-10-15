package com.example.SK_Prj2_Rakic_Vasic.NotificationService.repository;


import com.example.SK_Prj2_Rakic_Vasic.NotificationService.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    Optional<Email> findEmailById(Long id);

}
