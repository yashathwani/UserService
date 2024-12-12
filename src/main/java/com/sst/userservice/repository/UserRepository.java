package com.sst.userservice.repository;

import com.sst.userservice.models.User;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Override
  User save(User user);
    
  Optional<User> findByEmail(String email);
}
