package com.example.wines_shop.service.impl;

import com.example.wines_shop.model.customer.Customer;
import com.example.wines_shop.repository.ICustomerRepository;
import com.example.wines_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Customer getCustomerByIdAccount(Long idAccount) {
        return iCustomerRepository.getCustomerByIdAccount(idAccount);
    }
}
