package com.sst.userservice.controller;


import com.sst.userservice.dto.LoginRequestDto;
import com.sst.userservice.dto.LogoutRequestDto;
import com.sst.userservice.dto.SignUpRequestDto;
import com.sst.userservice.dto.UserDto;
import com.sst.userservice.models.Token;
import com.sst.userservice.models.User;
import com.sst.userservice.service.UserService;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto requestDto) {
        User user=userService.signUp(requestDto.getName(),requestDto.getEmail(),requestDto.getPassword());
        return UserDto.from(user);
    }

    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto requestDto) {
        Token token=userService.login(requestDto.getEmail(),requestDto.getPassword());
        return token;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto) {
        userService.logout(requestDto.getToken());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable String token){
        User user = userService.validateToken(token);
        return UserDto.from(user);
    }


}
