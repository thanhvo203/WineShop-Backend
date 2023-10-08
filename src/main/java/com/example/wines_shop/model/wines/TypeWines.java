package com.example.wines_shop.model.wines;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeWines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeWines;

    private String nameTypeWines;

    public TypeWines(Long idTypeWines, String nameTypeWines) {
        this.idTypeWines = idTypeWines;
        this.nameTypeWines = nameTypeWines;
    }

    public TypeWines() {
    }

    public Long getIdTypeWines() {
        return idTypeWines;
    }

    public void setIdTypeWines(Long idTypeWines) {
        this.idTypeWines = idTypeWines;
    }

    public String getNameTypeWines() {
        return nameTypeWines;
    }

    public void setNameTypeWines(String nameTypeWines) {
        this.nameTypeWines = nameTypeWines;
    }
}
