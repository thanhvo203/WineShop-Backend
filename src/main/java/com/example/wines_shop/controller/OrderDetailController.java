package com.example.wines_shop.controller;


import com.example.wines_shop.service.IOrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wines/order-detail")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService iOrderDetailService;
    
    @PostMapping("/add")
    public ResponseEntity<?> addOrderDetail(@RequestParam("currentPrice") Double currentPrice,
                                            @RequestParam("quality") Integer quality,
                                            @RequestParam("idOrder") Long idOrder,
                                            @RequestParam("idWines") Long idWines) {
        if (idOrder != null || idWines != null) {
            iOrderDetailService.addOrderDetail(currentPrice, quality, idOrder, idWines);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
