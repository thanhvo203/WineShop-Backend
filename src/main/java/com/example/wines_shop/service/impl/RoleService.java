package com.example.wines_shop.service.impl;

import com.example.wines_shop.model.account.Role;
import com.example.wines_shop.repository.IRoleRepository;
import com.example.wines_shop.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Optional<Role> findByName(String name) {
        return iRoleRepository.findByNameRole(name);
    }

}
