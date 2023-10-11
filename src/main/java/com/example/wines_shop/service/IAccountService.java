package com.example.wines_shop.service;

import com.example.wines_shop.model.account.Users;

import java.util.Optional;

public interface IAccountService {
    Optional<Users> findByEmail(String email);
    Boolean existsAccountByEmail(String email);
    Users save(Users users);
}
