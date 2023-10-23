package com.example.wines_shop.service.impl;

import com.example.wines_shop.repository.IOrderDetailRepository;
import com.example.wines_shop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;
    @Override
    public void addOrderDetail(Double currentPrice, Integer quality, Long idOrder, Long idWines) {
        iOrderDetailRepository.addOrderDetail(currentPrice, quality, idOrder, idWines);
    }


}
