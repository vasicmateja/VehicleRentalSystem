package com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.serviceImplementation;


import com.example.SK_Prj2_Rakic_Vasic.NotificationService.domain.NotificationType;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.notificationTypeDto.NotificationTypeDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper.NotificationTypeMapper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.repository.NotificationTypeRepository;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.NotificationTypeService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class NotificationTypeServiceImplementation implements NotificationTypeService {

    NotificationTypeMapper notificationTypeMapper;
    NotificationTypeRepository notificationTypeRepository;


    public NotificationTypeServiceImplementation(NotificationTypeMapper notificationTypeMapper, NotificationTypeRepository notificationTypeRepository) {
        this.notificationTypeMapper = notificationTypeMapper;
        this.notificationTypeRepository = notificationTypeRepository;
    }

    @Override
    public NotificationTypeDto findByID(Long id) {
        return notificationTypeRepository.findById(id).map(notificationTypeMapper::notificationTypeToNotificationTypeDto).orElseThrow(()-> new NotFoundException("Manager ciji je id:" + id + "nije pronadjen"));
    }

    @Override
    public List<NotificationTypeDto> findAll() {
        List<NotificationTypeDto> notificationTypeDtos = new ArrayList<>();

        notificationTypeRepository.findAll().forEach(notificationType -> {

            notificationTypeDtos.add(notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType));

        });

        return notificationTypeDtos;
    }

    @Override
    public NotificationTypeDto add(NotificationTypeCreateDto notificationTypeCreateDto) {

        NotificationType notificationType = notificationTypeMapper.notificationTypeCreateDtoToNotificationType(notificationTypeCreateDto);

        notificationTypeRepository.save(notificationType);

        return notificationTypeMapper.notificationTypeToNotificationTypeDto(notificationType);
    }

    @Override
    public Boolean delete(Long id) {
        NotificationType notificationType = notificationTypeRepository.findById(id).orElseThrow(()-> new NotFoundException("User ciji je id:" + id + "nije pronadjen"));

        notificationTypeRepository.delete(notificationType);
        return true;
    }

    @Override
    public NotificationTypeDto update(NotificationTypeDto notificationTypeDto) {

        NotificationType notificationType = notificationTypeRepository.findById(notificationTypeDto.getId()).orElseThrow(()-> new NotFoundException("User ciji je id:" + notificationTypeDto.getId() + "nije pronadjen"));

        notificationType.setTypeName(notificationTypeDto.getTypeName());

        notificationTypeRepository.save(notificationType);
        return notificationTypeDto;
    }

}
