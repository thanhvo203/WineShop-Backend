package com.example.wines_shop.service;


import com.example.wines_shop.model.cart.OrderDetails;

import java.util.List;

public interface IOrderDetailService {
    void addOrderDetail(Double currentPrice,
                        Integer quality,
                        Long idOrder,
                        Long idWines);
    List<OrderDetails> listDetailHistory(Long id);
}
