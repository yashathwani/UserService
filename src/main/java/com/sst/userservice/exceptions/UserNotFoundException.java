package com.sst.userservice.exceptions;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(String message){
        super(message);
    }
    
}
