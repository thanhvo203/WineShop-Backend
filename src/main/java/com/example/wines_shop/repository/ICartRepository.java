package com.example.wines_shop.repository;

import com.example.wines_shop.model.cart.Cart;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Transactional
public interface ICartRepository extends JpaRepository<Cart, Long> {

    @Query(nativeQuery = true, value = "select * from cart\n" +
            "                        left join customer c on c.id_customer = cart.id_customer\n" +
            "                        left join account a on a.id_account = c.id_account\n" +
            "                        left join wines w on w.id_wines = cart.id_wines\n" +
            "                        where a.id_account = :idAccount\n" +
            "                        and cart.status = 0\n" +
            "order by cart.id_cart desc ")
    List<Cart> findAllByIdCustomerAndStatusIsFalse(@Param("idAccount") Long id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into cart ( quality, status, id_customer, id_wines)\n" +
            "VALUES (:newQuality,0,:idCustomer,:idWines) " +
            "ON DUPlICATE KEY UPDATE quality = quality + :newQuality")
    void addToCart(@Param("newQuality") Integer quality, @Param("idCustomer") Long idCustomer, @Param("idWines") Long idWines);

    @Modifying
    @Query(nativeQuery = true, value = "update cart set\n" +
            "cart.quality = :newQuantity,\n" +
            "cart.id_wines = :idWines,\n" +
            "cart.id_customer = :idCustomer\n" +
            "where id_cart = :idCart")
    void updateQuantityCart(@Param("newQuantity") Integer newQuantity, @Param("idCustomer") Long idCustomer, @Param("idWines") Long idWines, @Param("idCart") Long idCart);

    @Modifying
    @Query(nativeQuery = true, value = "delete from cart where cart.id_wines = :idWines and cart.id_customer = :idCustomer")
    void deleteWinesInCart(@Param("idWines") Long idWines,@Param("idCustomer") Long idCustomer);


}
