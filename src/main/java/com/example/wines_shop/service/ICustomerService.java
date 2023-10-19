package com.example.wines_shop.service;

import com.example.wines_shop.model.customer.Customer;

public interface ICustomerService {

    Customer getCustomerByIdAccount(Long idAccount);
}
