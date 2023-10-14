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

    @GetMapping("/list")
    public ResponseEntity<List<Cart>>findAllCartByCustomerId(@RequestParam("id") Long id) {
        if (iCartService.findAllByIdCustomerAndStatusIsFalse(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iCartService.findAllByIdCustomerAndStatusIsFalse(id),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addToCart(@RequestParam("quality")Integer quality,
                                       @RequestParam("idCustomer") Long idCustomer,
                                       @RequestParam("idWines") Long idWines) {
        if (idCustomer != null && idWines != null) {
            iCartService.addToCart(quality,idCustomer,idWines);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @PatchMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteWineFromCart(@PathVariable("id") Long idWines) {
        if (idWines != null){
            iCartService.deleteWinesInCart(idWines);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateCart(@PathVariable("id") Long idCart,
                                                 @RequestParam("newQuantity") Integer newQuantity,
                                                 @RequestParam("idWines")Long idWines,
                                                 @RequestParam("idCustomer")Long idCustomer) {
        if (idCart != null) {
            iCartService.updateQuantityCart(newQuantity, idCustomer, idWines, idCart);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
