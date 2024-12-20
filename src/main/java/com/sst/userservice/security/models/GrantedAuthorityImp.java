package com.sst.userservice.security.models;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sst.userservice.models.Role;

@JsonDeserialize
public class GrantedAuthorityImp implements GrantedAuthority {
    private String authority;

    GrantedAuthorityImp() {
    }
    GrantedAuthorityImp(Role role) {
        this.authority = role.getValue();
    }
    @Override
    public String getAuthority() {
        return authority;
    }



}