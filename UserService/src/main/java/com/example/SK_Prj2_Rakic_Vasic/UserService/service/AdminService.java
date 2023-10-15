package com.example.SK_Prj2_Rakic_Vasic.UserService.service;

import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelCreateDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.discountLevel.DiscountLevelDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.AdminDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.users.UserDto;

public interface AdminService {

    AdminDto findById(Long id);
    AdminDto update(AdminDto adminDto);
    Boolean ban(Long id);
    DiscountLevelDto addNewDiscountLevel(DiscountLevelCreateDto discountLevelCreateDto);
}
