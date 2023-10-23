package com.example.wines_shop.repository;

import com.example.wines_shop.model.cart.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IOrderDetailRepository extends JpaRepository<OrderDetails,Long> {

    @Modifying
    @Query(nativeQuery = true,value = "insert into order_details (current_price, quality, id_orders, id_wines)\n" +
            "values (:currentPrice,:quality,:idOrder,:idWines)")
    void addOrderDetail (@Param("currentPrice") Double currentPrice,
                         @Param("quality") Integer quality,
                         @Param("idOrder") Long idOrder,
                         @Param("idWines") Long idWines);


}
