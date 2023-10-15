package com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.domain.NotificationType;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeDto;
import org.springframework.stereotype.Component;

@Component
public class NotificationTypeMapper {

    public NotificationTypeMapper() {
    }

    public NotificationTypeDto notificationTypeToNotificationTypeDto(NotificationType notificationType){
        NotificationTypeDto notificationTypeDto = new NotificationTypeDto();

        notificationTypeDto.setTypeName(notificationType.getTypeName());


        return notificationTypeDto;
    }

    public NotificationType notificationTypeCreateDtoToNotificationType(NotificationTypeCreateDto notificationTypeCreateDto){
        NotificationType notificationType = new NotificationType();

        notificationType.setTypeName(notificationType.getTypeName());

        return notificationType;
    }

}
