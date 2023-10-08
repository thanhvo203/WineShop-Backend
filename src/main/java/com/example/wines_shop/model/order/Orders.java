package com.example.wines_shop.model.order;

import com.example.wines_shop.model.cart.OrderDetails;
import com.example.wines_shop.model.customer.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    private String nameOrder;
    private String addressOrder;
    private String telOrder;
    private Boolean status;
    private Date dateOrder;
    private Double priceOrder;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer idCustomer;

    public Orders(Long idOrder, String nameOrder, String addressOrder, String telOrder, Boolean status, Date dateOrder, Double priceOrder, Customer idCustomer) {
        this.idOrder = idOrder;
        this.nameOrder = nameOrder;
        this.addressOrder = addressOrder;
        this.telOrder = telOrder;
        this.status = status;
        this.dateOrder = dateOrder;
        this.priceOrder = priceOrder;
        this.idCustomer = idCustomer;
    }

    public Orders() {
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public String getAddressOrder() {
        return addressOrder;
    }

    public void setAddressOrder(String addressOrder) {
        this.addressOrder = addressOrder;
    }

    public String getTelOrder() {
        return telOrder;
    }

    public void setTelOrder(String telOrder) {
        this.telOrder = telOrder;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Double getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(Double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

}
