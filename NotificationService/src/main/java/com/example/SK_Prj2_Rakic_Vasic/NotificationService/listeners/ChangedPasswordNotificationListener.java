package com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.ChangePasswordDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.EmailDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper.NotificationTypeMapper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;

public class ChangedPasswordNotificationListener {
    private MessageHelper messageHelper;
    private EmailService emailService;
    private NotificationTypeMapper notificationTypeMapper;

    public ChangedPasswordNotificationListener(MessageHelper messageHelper, EmailService emailService, NotificationTypeMapper notificationTypeMapper) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;
        this.notificationTypeMapper = notificationTypeMapper;
    }


    @JmsListener(destination = "${destination.changePassword}", concurrency = "5-10")
    public void changedPasswordNotificationListener(Message message) throws JMSException {
        ChangePasswordDto changePasswordDto = messageHelper.getMessage(message,ChangePasswordDto.class);
        System.out.println(changePasswordDto);

        EmailDto emailDto = emailService.addChangePasswordDtoToEmail(changePasswordDto);


        emailService.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getContent());
    }
}
