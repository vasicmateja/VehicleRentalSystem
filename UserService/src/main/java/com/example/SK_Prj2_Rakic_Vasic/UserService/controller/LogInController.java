package com.example.SK_Prj2_Rakic_Vasic.UserService.controller;

import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token.TokenRequestDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token.TokenResponseDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.LogInService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LogInController {

    private LogInService loginService;

    public LogInController(LogInService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody TokenRequestDto tokenRequestDto) {
        return new ResponseEntity<>(loginService.login(tokenRequestDto), HttpStatus.OK);
    }


}
