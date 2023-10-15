package com.example.SK_Prj2_Rakic_Vasic.UserService.service;

import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token.TokenRequestDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token.TokenResponseDto;

public interface LogInService {

    TokenResponseDto login(TokenRequestDto tokenRequestDto);

}
