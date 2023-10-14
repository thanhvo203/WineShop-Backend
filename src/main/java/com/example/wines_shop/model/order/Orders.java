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
    private Date dateOrder;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer idCustomer;

    public Orders(Long idOrder, Date dateOrder, Customer idCustomer) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
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

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }
}
