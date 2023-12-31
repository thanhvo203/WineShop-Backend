package com.example.wines_shop.service.impl;

import com.example.wines_shop.model.wines.Wines;
import com.example.wines_shop.repository.IWinesRepository;
import com.example.wines_shop.service.IWinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinesService implements IWinesService {
    @Autowired
    private IWinesRepository iWinesRepository;
    @Override
    public List<Wines> findAllByFlagDeletedIsFalse() {
        return iWinesRepository.findAllByFlagWinesIsFalse();
    }

    @Override
    public Wines getWinesById(Long id) {
        return iWinesRepository.getWinesById(id);
    }

    @Override
    public Wines getLargestPrice() {
        return iWinesRepository.getLargestPrice();
    }

    @Override
    public Page<Wines> getListWines(Pageable pageable, int firstAlcohol,
                                    int lastAlcohol,
                                     String color,
                                     String flavor,
                                     String country,
                                    String nameType,String nameWines,int minPrice,int maxPrice) {
        return iWinesRepository.getListWines(pageable,firstAlcohol,lastAlcohol,color,flavor,country,nameType,nameWines,minPrice,maxPrice);
    }

    @Override
    public void updateQuantityWines(Integer newQuantity, Long idWines) {
        iWinesRepository.updateQuantityWines(newQuantity, idWines);
    }
}
