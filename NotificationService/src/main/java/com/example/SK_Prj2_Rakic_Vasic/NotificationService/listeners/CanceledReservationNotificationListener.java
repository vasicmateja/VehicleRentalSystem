package com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.CancelReservationDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.EmailDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper.NotificationTypeMapper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;

public class CanceledReservationNotificationListener {
    private final MessageHelper messageHelper;
    private final EmailService emailService;


    public CanceledReservationNotificationListener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;

    }

    @JmsListener(destination = "${destination.cancellation}", concurrency = "5-10")
    public void changedPasswordNotificationListener(Message message) throws JMSException {
        CancelReservationDto cancelReservationDto= messageHelper.getMessage(message,CancelReservationDto.class);
        System.out.println(cancelReservationDto);

        EmailDto emailDto = emailService.addCancelReservationDtoToEmail(cancelReservationDto);


        emailService.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getContent());
    }
}
