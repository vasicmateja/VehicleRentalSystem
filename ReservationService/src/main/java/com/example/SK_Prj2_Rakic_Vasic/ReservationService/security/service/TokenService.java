package com.example.SK_Prj2_Rakic_Vasic.ReservationService.security.service;

import io.jsonwebtoken.Claims;

public interface TokenService {

    String generate(Claims claims);

    Claims parseToken(String jwt);
}
