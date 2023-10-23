package com.example.wines_shop.repository;

import com.example.wines_shop.model.order.OrderProjection;
import com.example.wines_shop.model.order.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<Orders,Long> {

//    @Modifying
//    @Query(nativeQuery = true,value = "insert into orders (date_order, status, id_customer,total_price)\n" +
//            "values (NOW(),false,:idCustomer,:totalPrice)")
//    void addOrder(@Param("idCustomer") Long idCustomer,@Param("totalPrice") Double totalPrice);

     @Query(nativeQuery = true,value = "    SELECT\n" +
             "                 o.id_order AS idOrder ,\n" +
             "                 DATE(o.date_order) AS dayOrder,\n" +
             "                 TIME(o.date_order) AS timeOrder,\n" +
             "                 o.total_price AS totalPrice\n" +
             "             FROM\n" +
             "                 orders o\n" +
             "             WHERE\n" +
             "                     o.id_customer = :idCustomer\n" +
             "               order by o.id_order desc ")
    Page<OrderProjection> getListHistoryNoDate(Pageable pageable, @Param("idCustomer") Long idCustomer);
    @Query(nativeQuery = true,value = "SELECT\n" +
            "                 o.id_order AS idOrder ,\n" +
            "                 DATE(o.date_order) AS dayOrder,\n" +
            "                 TIME(o.date_order) AS timeOrder,\n" +
            "                 o.total_price AS totalPrice\n" +
            "             FROM\n" +
            "                 orders o\n" +
            "             WHERE\n" +
            "                     o.id_customer = :idCustomer\n" +
            "               AND (DATE(o.date_order) >= :startDate)\n" +
            "               AND (DATE(o.date_order) <= :endDate) " +
            "               order by o.id_order desc ")
    Page<OrderProjection> getListHistory(Pageable pageable, @Param("idCustomer") Long idCustomer,
                                         @Param("startDate") String startDate,
                                         @Param("endDate") String endDate);







}
