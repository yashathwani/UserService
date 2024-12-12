package com.sst.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
public class User extends BaseModel{

    private String name;
    private String email;

    @ManyToMany
    private List<Role> roles;

    private String hashedPassword;
   private boolean isEmailVerified;

   public String getName() {
       return name;
   }
    public String getEmail() {
         return email;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public boolean isEmailVerified() {
        return isEmailVerified;
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
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }




}
