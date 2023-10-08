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
    public Page<Wines> getListWines(Pageable pageable) {
        return iWinesRepository.getListWines(pageable);
    }
}
