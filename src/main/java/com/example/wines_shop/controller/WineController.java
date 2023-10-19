package com.example.wines_shop.controller;

import com.example.wines_shop.model.wines.Wines;
import com.example.wines_shop.service.IWinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wines")
public class WineController {
    @Autowired
    private IWinesService iWinesService;

    @GetMapping("")
    public ResponseEntity<List<Wines>> getListWines () {
        return new ResponseEntity<>(iWinesService.findAllByFlagDeletedIsFalse(), HttpStatus.OK);
    }
    @GetMapping("/largest-price")
    public ResponseEntity<Wines> getLargestPrice() {
        return new ResponseEntity<>(iWinesService.getLargestPrice(),HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Page<Wines>> getListWinesPage(@RequestParam("page") Integer page,
                                                        @RequestParam("firstAlcohol") String firstAlcohol,
                                                        @RequestParam("lastAlcohol") String lastAlcohol,
                                                        @RequestParam("color") String color,
                                                        @RequestParam("flavor") String flavor,
                                                        @RequestParam("country") String country,
                                                        @RequestParam("nameType") String nameType,
                                                        @RequestParam("nameWines")String nameWines,
                                                        @RequestParam("minPrice") String minPrice,
                                                        @RequestParam("maxPrice") String maxPrice) {
        Pageable pageable = PageRequest.of(page,9);
        int first = Integer.parseInt(firstAlcohol);
        int last = Integer.parseInt(lastAlcohol);
        int min = Integer.parseInt(minPrice);
        int max = Integer.parseInt(maxPrice);
        Page<Wines> wines = iWinesService.getListWines(pageable,first,last,color,flavor,country,nameType,nameWines,min,max);
        if (wines.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(wines,HttpStatus.OK);
    }

    @GetMapping("/detail-product/{id}")
    public ResponseEntity<Wines> getWinesById(@PathVariable("id") Long id) {
        if (iWinesService.getWinesById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(iWinesService.getWinesById(id),HttpStatus.OK);
    }



}
