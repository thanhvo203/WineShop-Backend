package com.example.wines_shop.service.impl;

import com.example.wines_shop.model.cart.Cart;
import com.example.wines_shop.repository.ICartRepository;
import com.example.wines_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Override
    public List<Cart> findAllByIdCustomerAndStatusIsFalse(Long id) {
        return cartRepository.findAllByIdCustomerAndStatusIsFalse(id);
    }

    @Override
    public void addToCart(Integer quality, Long idCustomer, Long idWines) {
        cartRepository.addToCart(quality,idCustomer,idWines);
    }

    @Override
    public void deleteWinesInCart(Long idWines) {
       cartRepository.deleteWinesInCart(idWines);
    }

    @Override
    public void updateQuantityCart(Integer quality, Long idCustomer, Long idWines, Long idCart) {
        cartRepository.updateQuantityCart(quality, idCustomer, idWines, idCart);
    }
}
