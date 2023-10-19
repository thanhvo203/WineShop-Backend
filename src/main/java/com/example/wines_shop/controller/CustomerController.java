package com.example.wines_shop.controller;


import com.example.wines_shop.model.customer.Customer;
import com.example.wines_shop.repository.ICustomerRepository;
import com.example.wines_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wines/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/{idAccount}")
    public ResponseEntity<Customer> getCustomerByIdAccount(@PathVariable("idAccount") Long idAccount) {
        if (idAccount == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(iCustomerService.getCustomerByIdAccount(idAccount),HttpStatus.OK);
    }

}
