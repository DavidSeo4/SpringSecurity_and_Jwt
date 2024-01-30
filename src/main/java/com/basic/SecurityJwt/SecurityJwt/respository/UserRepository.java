package com.basic.SecurityJwt.SecurityJwt.respository;

import com.basic.SecurityJwt.SecurityJwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

     Optional<User> findByUsername(String username);
}
