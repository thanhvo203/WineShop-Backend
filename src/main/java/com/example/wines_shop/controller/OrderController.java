package com.example.wines_shop.controller;

import com.example.wines_shop.model.order.OrderProjection;
import com.example.wines_shop.model.order.Orders;
import com.example.wines_shop.repository.IOrderRepository;
import com.example.wines_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wines/order")
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/add")
    public ResponseEntity<Orders> addOrder(@RequestParam("idCustomer") Long idCustomer, @RequestParam("totalPrice") Double totalPrice) {
        if (idCustomer != null) {
            return ResponseEntity.ok(iOrderService.addOrder(idCustomer,totalPrice));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/history/{idCustomer}")
    public ResponseEntity<Page<OrderProjection>> getListHistory(@RequestParam("page") Integer page,
                                                                @PathVariable("idCustomer") Long idCustomer,
                                                                @RequestParam(value = "startDate",required = false) String startDate,
                                                                @RequestParam(value = "endDate",required = false) String endDate) {
        Pageable pageable = PageRequest.of(page,5);
        if (idCustomer == null) {
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(startDate.equals("null") && endDate.equals("null")) {
            return new ResponseEntity<>(iOrderService.getListHistoryNoDate(pageable,idCustomer),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(iOrderService.getListHistory(pageable,idCustomer,startDate,endDate),HttpStatus.OK);
        }

    }


}
