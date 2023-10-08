package com.example.wines_shop.model.cart;

import com.example.wines_shop.model.customer.Customer;
import com.example.wines_shop.model.wines.Wines;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCart;

    private Integer quality;
    private Boolean status;
    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer idCustomer;
    @OneToOne
    @JoinColumn(name = "id_wines")
    private Wines wines;

    public Cart(Long idCart, Integer quality, Boolean status, Customer idCustomer, Wines wines) {
        this.idCart = idCart;
        this.quality = quality;
        this.status = status;
        this.idCustomer = idCustomer;
        this.wines = wines;
    }

    public Cart() {
    }

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Wines getWines() {
        return wines;
    }

    public void setWines(Wines wines) {
        this.wines = wines;
    }
}
