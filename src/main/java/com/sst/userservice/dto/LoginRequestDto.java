package com.sst.userservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
    private String email;
    private String password;
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void  setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
