package com.example.SK_Prj2_Rakic_Vasic.UserService.security.service;

import io.jsonwebtoken.Claims;

public interface TokenService {

    String generate(Claims claims);

    Claims parseToken(String jwt);
}
