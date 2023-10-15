package com.example.SK_Prj2_Rakic_Vasic.UserService.service;


import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserDto;
import java.util.List;

public interface UserService {

    UserDto findById(Long id);
    List<UserDto> findAll();
    UserDto add(UserCreateDto userCreateDto);
    Boolean delete(Long id);
    UserDto update(UserDto userDto);
}
