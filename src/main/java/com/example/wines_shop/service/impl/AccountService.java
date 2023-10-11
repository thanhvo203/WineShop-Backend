package com.example.wines_shop.service.impl;

import com.example.wines_shop.model.account.Users;
import com.example.wines_shop.repository.UserRepository;
import com.example.wines_shop.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private UserRepository iAccountRepository;
    @Override
    public Optional<Users> findByEmail(String email) {
        return iAccountRepository.findByEmail(email);
    }

    @Override
    public Boolean existsAccountByEmail(String email) {
        return iAccountRepository.existsAccountByEmail(email);
    }

    @Override
    public Users save(Users users) {
        return iAccountRepository.save(users);
    }
}
