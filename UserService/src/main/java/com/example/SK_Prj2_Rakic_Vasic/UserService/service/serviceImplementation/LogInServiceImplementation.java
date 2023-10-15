package com.example.SK_Prj2_Rakic_Vasic.UserService.service.serviceImplementation;

import com.example.SK_Prj2_Rakic_Vasic.UserService.domain.User;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token.TokenRequestDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token.TokenResponseDto;
import com.example.SK_Prj2_Rakic_Vasic.UserService.exception.NotFoundException;
import com.example.SK_Prj2_Rakic_Vasic.UserService.repository.UserRepository;
import com.example.SK_Prj2_Rakic_Vasic.UserService.security.service.TokenService;
import com.example.SK_Prj2_Rakic_Vasic.UserService.service.LogInService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LogInServiceImplementation implements LogInService {


        private TokenService tokenService;
        private UserRepository userRepository;

    public LogInServiceImplementation(TokenService tokenService, UserRepository userRepository) {
            this.tokenService = tokenService;
            this.userRepository = userRepository;
        }

        @Override
        public TokenResponseDto login(TokenRequestDto tokenRequestDto) {
            //Try to find active user for specified credentials


            User user = userRepository
                    .findUserByEmailAndPassword(tokenRequestDto.getEmail(), tokenRequestDto.getPassword())
                    .orElseThrow(() -> new NotFoundException(String
                            .format("User with email: %s and password: %s not found.", tokenRequestDto.getEmail(),
                                    tokenRequestDto.getPassword())));



            if(user.isBanned()){
                return  new TokenResponseDto("Nemas dozvolu da pristupis app");
            }
            //Create token payload
            Claims claims = Jwts.claims();
            claims.put("id", user.getId());
            claims.put("role", user.getRole().getRoleName());
            claims.put("email",user.getEmail());
            claims.put("banned",user.isBanned());

            //Generate token
            return new TokenResponseDto(tokenService.generate(claims));
    }
}
