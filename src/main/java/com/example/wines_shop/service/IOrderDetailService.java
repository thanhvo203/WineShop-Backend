package com.example.wines_shop.service;


public interface IOrderDetailService {
    void addOrderDetail(Double currentPrice,
                        Integer quality,
                        Long idOrder,
                        Long idWines);
}
