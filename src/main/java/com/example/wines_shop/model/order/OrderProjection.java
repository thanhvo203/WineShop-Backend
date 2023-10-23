package com.example.wines_shop.model.order;

import java.time.LocalDateTime;
import java.util.Date;

public interface OrderProjection {
     Long getIdOrder();
     Date getDayOrder();
     String getTimeOrder();
     Double getTotalPrice();

}
