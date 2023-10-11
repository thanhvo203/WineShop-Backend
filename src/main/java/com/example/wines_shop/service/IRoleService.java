package com.example.wines_shop.service;


import com.example.wines_shop.model.account.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);
}
