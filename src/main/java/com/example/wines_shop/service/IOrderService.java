package com.example.wines_shop.service;


import com.example.wines_shop.model.order.OrderProjection;
import com.example.wines_shop.model.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IOrderService {
    Orders addOrder(Long idCustomer, Double totalPrice);
    Page<OrderProjection> getListHistory(Pageable pageable,Long idCustomer,
                                         String startDate,
                                         String endDate);
    Page<OrderProjection> getListHistoryNoDate(Pageable pageable,Long idCustomer);
}
