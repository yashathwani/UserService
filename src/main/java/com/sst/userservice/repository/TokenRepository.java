package com.sst.userservice.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sst.userservice.models.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    @Override
    Token save(Token token);
    

    Optional<Token> findByValueAndDeleted(String value, boolean deleted);
    
    Optional<Token> findByValueAndDeletedAndExpiryAtGreaterThan(String value, boolean deleted, Date currentDate);
}
