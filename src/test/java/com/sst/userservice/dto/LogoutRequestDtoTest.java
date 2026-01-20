package com.sst.userservice.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogoutRequestDtoTest {

    @Test
    void testGettersAndSetters() {
        LogoutRequestDto logoutRequestDto = new LogoutRequestDto();
        String testToken = "test-token";
        
        logoutRequestDto.setToken(testToken);
        
        assertEquals(testToken, logoutRequestDto.getToken(), "Token should match the one set");
    }
}
