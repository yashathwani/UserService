package com.sst.userservice.dto;

import com.sst.userservice.models.Role;
import com.sst.userservice.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private List<Role> roles;
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public static UserDto from(User user) {
        if(user==null){
            return null;
        }
     UserDto userDto=new UserDto();
     userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setRoles(user.getRoles());

        return userDto;
    }
}

