package com.example.wines_shop.model.cart;

import com.example.wines_shop.model.order.Orders;
import com.example.wines_shop.model.wines.Wines;

import javax.persistence.*;


@Entity
public class OrderDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderDetails;

    private Double currentPrice;

    private Integer quality;
    @ManyToOne
    @JoinColumn(name = "id_orders")
    private Orders idOrders;

    @ManyToOne
    @JoinColumn(name = "id_wines")
    private Wines idWines;

    public OrderDetails(Long idOrderDetails, Double currentPrice, Integer quality, Orders idOrders, Wines idWines) {
        this.idOrderDetails = idOrderDetails;
        this.currentPrice = currentPrice;
        this.quality = quality;
        this.idOrders = idOrders;
        this.idWines = idWines;
    }

    public OrderDetails() {
    }

    public Long getIdOrderDetails() {
        return idOrderDetails;
    }

    public void setIdOrderDetails(Long idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Orders getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Orders idOrders) {
        this.idOrders = idOrders;
    }

    public Wines getIdWines() {
        return idWines;
    }

    public void setIdWines(Wines idWines) {
        this.idWines = idWines;
    }
}
