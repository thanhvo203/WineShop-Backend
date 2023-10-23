package com.example.wines_shop.service.impl;

import com.example.wines_shop.model.order.OrderProjection;
import com.example.wines_shop.model.order.Orders;
import com.example.wines_shop.repository.ICustomerRepository;
import com.example.wines_shop.repository.IOrderRepository;
import com.example.wines_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Orders addOrder(Long idCustomer, Double totalPrice) {

         Orders orders = new Orders();
         orders.setTotalPrice(totalPrice);
         orders.setDateOrder(LocalDateTime.now());
         orders.setIdCustomer(iCustomerRepository.findById(idCustomer).get());
         orders.setStatus(false);
        Orders orders1 =  iOrderRepository.save(orders);
         return orders1;
    }

    @Override
    public Page<OrderProjection> getListHistory(Pageable pageable, Long idCustomer, String startDate, String endDate) {
        return iOrderRepository.getListHistory(pageable,idCustomer, startDate, endDate);
    }

    @Override
    public Page<OrderProjection> getListHistoryNoDate(Pageable pageable, Long idCustomer) {
        return iOrderRepository.getListHistoryNoDate(pageable, idCustomer);
    }


}
