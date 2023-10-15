package com.example.SK_Prj2_Rakic_Vasic.UserService.dto.token;

public class TokenRequestDto {

    private String email;
    private String password;

    public TokenRequestDto() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
