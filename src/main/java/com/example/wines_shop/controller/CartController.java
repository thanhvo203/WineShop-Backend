package com.example.wines_shop.controller;

import com.example.wines_shop.model.cart.Cart;
import com.example.wines_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wines/cart")
public class CartController {
    @Autowired
    private ICartService iCartService;

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Cart>> findAllCartByCustomerId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iCartService.findAllByIdCustomerAndStatusIsFalse(id), HttpStatus.OK);
    }

    @PostMapping("/add/{quality}/{idCustomer}/{idWines}")
    public ResponseEntity<HttpStatus> addToCart(@PathVariable("quality") Integer quality,
                                                @PathVariable("idCustomer") Long idCustomer,
                                                @PathVariable("idWines") Long idWines) {
        if (idCustomer != null && idWines != null) {
            iCartService.addToCart(quality, idCustomer, idWines);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{idWines}")
    public ResponseEntity<HttpStatus> deleteWineFromCart(@PathVariable("idWines") Long idWines,@RequestParam("idCustomer")Long idCustomer) {
        if (idWines != null) {
            iCartService.deleteWinesInCart(idWines,idCustomer);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateCart(@PathVariable("id") Long idCart,
                                                 @RequestParam("newQuantity") Integer newQuantity,
                                                 @RequestParam("idWines") Long idWines,
                                                 @RequestParam("idCustomer") Long idCustomer) {
        if (idCart != null) {
            iCartService.updateQuantityCart(newQuantity, idCustomer, idWines, idCart);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
