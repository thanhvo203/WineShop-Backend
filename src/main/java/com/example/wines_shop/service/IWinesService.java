package com.example.wines_shop.service;

import com.example.wines_shop.model.wines.Wines;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IWinesService {
    List<Wines> findAllByFlagDeletedIsFalse();
    Wines getWinesById (Long id);
    Wines getLargestPrice();
    Page<Wines> getListWines (Pageable pageable,int firstAlcohol,
                              int lastAlcohol,
                              String color,
                              String flavor,
                              String country,
                              String nameType,String nameWines, int minPrice,int maxPrice);
    void updateQuantityWines( Integer newQuantity, Long idWines);
}
