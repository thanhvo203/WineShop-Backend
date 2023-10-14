package com.example.wines_shop.service;

import com.example.wines_shop.model.cart.Cart;



import java.util.List;

public interface ICartService {

    List<Cart> findAllByIdCustomerAndStatusIsFalse(Long id);
    void addToCart(Integer quality,Long idCustomer, Long idWines);
    void deleteWinesInCart(Long idWines);
    void updateQuantityCart(Integer quality, Long idCustomer,  Long idWines,  Long idCart);
}
