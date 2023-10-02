package com.example.wines_shop.model.wines;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeWines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeWines;

    private String nameTypeWines;

    public TypeWines(int idTypeWines, String nameTypeWines) {
        this.idTypeWines = idTypeWines;
        this.nameTypeWines = nameTypeWines;
    }

    public TypeWines() {
    }

    public int getIdTypeWines() {
        return idTypeWines;
    }

    public void setIdTypeWines(int idTypeWines) {
        this.idTypeWines = idTypeWines;
    }

    public String getNameTypeWines() {
        return nameTypeWines;
    }

    public void setNameTypeWines(String nameTypeWines) {
        this.nameTypeWines = nameTypeWines;
    }
}
