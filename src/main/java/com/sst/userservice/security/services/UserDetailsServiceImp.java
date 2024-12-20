package com.sst.userservice.security.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sst.userservice.models.User;
import com.sst.userservice.repository.UserRepository;
import com.sst.userservice.security.models.UserDetailsImp; 

@Service
@JsonDeserialize
public class UserDetailsServiceImp implements UserDetailsService {
    private UserRepository userRepository;

    UserDetailsServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User getUser = user.get();
        return new UserDetailsImp(getUser);
       
    }
    
}
