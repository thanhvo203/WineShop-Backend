package com.example.wines_shop.repository;

import com.example.wines_shop.model.account.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Boolean existsAccountByEmail(String email);
}
