package com.example.SK_Prj2_Rakic_Vasic.NotificationService.service;


import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeDto;

import java.util.List;

public interface NotificationTypeService {

    NotificationTypeDto findByID(Long id);
    List<NotificationTypeDto> findAll();
    NotificationTypeDto add(NotificationTypeCreateDto notificationTypeCreateDto);
    Boolean delete(Long id);
    NotificationTypeDto update(NotificationTypeDto notificationTypeDto);

}
