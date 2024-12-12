package com.sst.userservice.service;

import com.sst.userservice.models.Token;
import com.sst.userservice.models.User;
import com.sst.userservice.repository.TokenRepository;
import com.sst.userservice.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private TokenRepository tokenRepository;


    public UserService(TokenRepository tokenRepository,BCryptPasswordEncoder bCryptPasswordEncoder,UserRepository userRepository){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
    }
    public User signUp(String name,String email,String password){
        User user=new User();
        user.setEmail(email);
        user.setName(name);
        String hashedPassword=bCryptPasswordEncoder.encode(password);
        user.setHashedPassword(hashedPassword);
        return userRepository.save(user);
    }

    public Token login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new Error("User with " + email + "does not exist");
        }
        User user = optionalUser.get();
        if (!bCryptPasswordEncoder.matches(password, user.getHashedPassword())) {
            return null;
        }

        Token token = generateToken(user);
        Token savedToken=tokenRepository.save(token);
        return savedToken;
    }

    public Token generateToken(User user) {
        LocalDate date = LocalDate.now();
        LocalDate thirtyDaysafter = date.plusDays(30);
        Date expiryDate = Date.from(thirtyDaysafter.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Token token = new Token();
        token.setExpiryAt(expiryDate);
        token.setUser(user);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        return token;

    }

    public void logout(String token) {
        Optional<Token> optionalToken = tokenRepository.findByValueAndDeleted(token, false);
        if (optionalToken.isEmpty()) {
            throw new Error("Token does not exist");
        }
        Token token1 = optionalToken.get();
        token1.setDeleted(true);
        tokenRepository.save(token1);
        
    }

    public User validateToken(String token) {
        Optional<Token> optionalToken = tokenRepository.findByValueAndDeletedAndExpiryAtGreaterThan(token, false,
                new Date());
        if (optionalToken.isEmpty()) {
            throw new Error("Token does not exist");
        }
        Token token1 = optionalToken.get();
        return token1.getUser();
    }

}
