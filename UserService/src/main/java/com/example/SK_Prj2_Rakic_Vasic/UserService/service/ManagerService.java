package com.example.SK_Prj2_Rakic_Vasic.UserService.service;

import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.ManagerDto;

import java.util.List;

public interface ManagerService {

    ManagerDto findById(Long id);
    List<ManagerDto> findAll();
    ManagerDto add(ManagerCreateDto managerCreateDto);
    Boolean delete(Long id);
    ManagerDto update(ManagerDto managerDto);
}
