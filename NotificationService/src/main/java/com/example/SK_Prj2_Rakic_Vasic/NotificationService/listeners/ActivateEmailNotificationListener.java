package com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.listeners.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.ActivationEmailDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.EmailDto;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.EmailService;
import org.springframework.jms.annotation.JmsListener;
import javax.jms.JMSException;
import javax.jms.Message;

public class ActivateEmailNotificationListener {
    private final MessageHelper messageHelper;
    private final EmailService emailService;


    public ActivateEmailNotificationListener(MessageHelper messageHelper, EmailService emailService) {
        this.messageHelper = messageHelper;
        this.emailService = emailService;

    }

    @JmsListener(destination = "${destination.activationEmail}", concurrency = "5-10")
    public void activationEmailNotification(Message message) throws JMSException{
        ActivationEmailDto activationEmailDto = messageHelper.getMessage(message,ActivationEmailDto.class);
        System.out.println(activationEmailDto);

        EmailDto emailDto = emailService.addActivationEmailToEmail(activationEmailDto);


        emailService.sendSimpleMessage(emailDto.getTo(),emailDto.getSubject(),emailDto.getContent());
    }

}
