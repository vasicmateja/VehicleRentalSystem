package com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.impl;

import com.example.SK_Prj2_Rakic_Vasic.ReservationService.controller.helper.MessageHelper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.domain.Reservation;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.dto.reservation.ReservationDto;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.mapper.ReservationMapper;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.CarRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.repository.ReservationRepository;
import com.example.SK_Prj2_Rakic_Vasic.ReservationService.service.ReservationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ReservationServiceImplementation implements ReservationService {
    private final ReservationRepository reservationRepository;

    private ReservationMapper reservationMapper;
    private final CarRepository carRepository;
    private JmsTemplate jmsTemplate;

    MessageHelper messageHelper;
    private String reservationDestination;
    private String cancelReservation;

    public ReservationServiceImplementation(ReservationRepository reservationRepository, ReservationMapper reservationMapper, CarRepository carRepository, JmsTemplate jmsTemplate, MessageHelper messageHelper,
                                            @Value("${destination.reservation}") String reservationDestination,
                                            @Value("${destination.cancellation}")String cancelReservation) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.carRepository = carRepository;
        this.jmsTemplate = jmsTemplate;
        this.messageHelper = messageHelper;
        this.reservationDestination = reservationDestination;
        this.cancelReservation=cancelReservation;
    }

    @Override
    public ReservationDto findReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new NotFoundException("Reservation ciji je id:" + id + "nije pronadjen"));

        return reservationMapper.reservationToReservationDto(reservation);
    }

    @Override
    public ReservationDto createRent(ReservationCreateDto reservationCreateDto) {
        Reservation reservation = reservationMapper.reservationCreateDtoToReservation(reservationCreateDto);
        reservationRepository.save(reservation);
       jmsTemplate.convertAndSend(reservationDestination,messageHelper.createTextMessage(reservationCreateDto));
        return reservationMapper.reservationToReservationDto(reservation);
    }

    @Override
    public ReservationDto updateRent(ReservationDto reservationDto) {
        Reservation reservation = reservationRepository.findReservationById(reservationDto.getId());
        reservation.setStartDate(reservationDto.getStartDate());
        reservation.setDuration(reservationDto.getDurationInDays());
        reservation.setUserId(reservationDto.getUserId());
        reservation.setCar(carRepository.findCarByModel(reservationDto.getCar()));


        reservationRepository.save(reservation);
        return reservationMapper.reservationToReservationDto(reservation);
    }

    @Override
    public Boolean deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new NotFoundException("Reservation ciji je id:" + id + "nije pronadjen"));

        //jmsTemplate.convertAndSend(cancelReservation,messageHelper.createTextMessage(reservation));

        //TODO DODAJ KAD SREDIS EUREKU
        reservationRepository.delete(reservation);
        return true;
    }
}
