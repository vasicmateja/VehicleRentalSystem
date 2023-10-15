package com.example.SK_Prj2_Rakic_Vasic.NotificationService.repository;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.domain.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface NotificationTypeRepository extends JpaRepository<NotificationType,Long> {


    Optional<NotificationType> findById(Long id);

    Optional<NotificationType> findNotificationTypeByTypeName(String name);
}
