package com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.EmailDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.ReservationEmailDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper.NotificationTypeMapper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;

public class SuccessfulReservationNotificationListener {
    private MessageHelper messageHelper;
    private EmailService emailService;
    private NotificationTypeMapper notificationTypeMapper;

    public SuccessfulReservationNotificationListener(MessageHelper messageHelper, EmailService emailService, NotificationTypeMapper notificationTypeMapper) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
        this.notificationTypeMapper = notificationTypeMapper;
    }

    @JmsListener(destination = "${destination.reservation}",concurrency = "5-10")
    public void reservationNotificationListener(Message message) throws JMSException{
        ReservationEmailDto reservationEmailDto = messageHelper.getMessage(message,ReservationEmailDto.class);
        System.out.println(reservationEmailDto);

        EmailDto emailDto = emailService.addReservationEmailDtoToEmail(reservationEmailDto);
        emailService.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getContent());

    }

}
