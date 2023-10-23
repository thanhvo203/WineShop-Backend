package com.example.wines_shop.model.order;

import com.example.wines_shop.model.cart.OrderDetails;
import com.example.wines_shop.model.customer.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    private LocalDateTime dateOrder;
    private Double totalPrice;

    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer idCustomer;

    public Orders(Long idOrder, LocalDateTime dateOrder, Customer idCustomer) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.idCustomer = idCustomer;
    }

    public Orders(Long idOrder, LocalDateTime dateOrder, Double totalPrice, Boolean status, Customer idCustomer) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.totalPrice = totalPrice;
        this.status = status;
        this.idCustomer = idCustomer;
    }

    public Orders(Double totalPrice, Customer idCustomer) {
        this.totalPrice = totalPrice;
        this.idCustomer = idCustomer;
    }

    public Orders(Long idOrder, LocalDateTime dateOrder, Double totalPrice, Customer idCustomer) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.totalPrice = totalPrice;
        this.idCustomer = idCustomer;
    }

    public Orders() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }
}
