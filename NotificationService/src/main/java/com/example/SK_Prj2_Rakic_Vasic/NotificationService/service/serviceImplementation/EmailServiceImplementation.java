package com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.serviceImplementation;

import com.example.SK_Prj2_Rakic_Vasic.NotificationService.domain.Email;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.dto.emailDto.*;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.mapper.EmailMapper;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.repository.EmailRepository;
import com.example.SK_Prj2_Rakic_Vasic.NotificationService.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmailServiceImplementation implements EmailService {

    private EmailRepository emailRepository;

    private EmailMapper emailMapper;

    public JavaMailSender mailSender;

    public EmailServiceImplementation(EmailRepository emailRepository, EmailMapper emailMapper, JavaMailSender mailSender) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
        this.mailSender = mailSender;
    }

    @Override
    public List<EmailDto> findAllEmails(String authorization) {
        List<EmailDto> emailDtoList = new ArrayList<>();

        emailRepository.findAll().forEach(email -> {
                emailDtoList.add(emailMapper.emailToEmailDto(email));
        });


        return emailDtoList;
    }

    @Override
    public EmailDto addActivationEmailToEmail(ActivationEmailDto activationEmailDto) {
        Email email = emailMapper.activationEmailDtoToEmail(activationEmailDto);

        emailRepository.save(email);
        return emailMapper.emailToEmailDto(email);
    }

    @Override
    public EmailDto addChangePasswordDtoToEmail(ChangePasswordDto changePasswordDto) {
        Email email = emailMapper.changePasswordDtoToEmail(changePasswordDto);

        emailRepository.save(email);
        return emailMapper.emailToEmailDto(email);
    }

    @Override
    public EmailDto addReservationEmailDtoToEmail(ReservationEmailDto reservationEmailDto) {
        Email email = emailMapper.reservationEmailDtoToEmail(reservationEmailDto);
        emailRepository.save(email);
        return emailMapper.emailToEmailDto(email);
    }

    @Override
    public EmailDto addCancelReservationDtoToEmail(CancelReservationDto cancelReservationDto) {
        Email email = emailMapper.cancelReservationDtoToEmail(cancelReservationDto);
        emailRepository.save(email);
        return emailMapper.emailToEmailDto(email);
    }

    @Override
    public EmailDto addReviewDtoToEmail(ReviewDto reviewDto) {
        Email email = emailMapper.reviewDtoToEmail(reviewDto);
        emailRepository.save(email);
        return emailMapper.emailToEmailDto(email);
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }


}
