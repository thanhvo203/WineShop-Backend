package com.example.wines_shop.model.wines;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Wines {
    @Id
    @GeneratedValue
    private Long idWines;

    private String nameWines;
    private Double priceWines;
    private String DescriptionWines;
    private String manufactureWines;
    private String countryManufacture;
    private String imageWines;
    private Integer quantity;

    private String flavorWines;
    private String colorWines;
    private Integer alcohol;
    private Date dateOfManufacture;
    private Date expirationDate;
    private Double flagWines;
    @OneToOne
    private TypeWines typeWines;

    public Wines() {
    }

    public Wines(Long idWines, String nameWines, Double priceWines, String descriptionWines, String manufactureWines, String countryManufacture, String imageWines, Integer quantity, String flavorWines, String colorWines, Integer alcohol, Date dateOfManufacture, Date expirationDate, Double flagWines, TypeWines typeWines) {
        this.idWines = idWines;
        this.nameWines = nameWines;
        this.priceWines = priceWines;
        DescriptionWines = descriptionWines;
        this.manufactureWines = manufactureWines;
        this.countryManufacture = countryManufacture;
        this.imageWines = imageWines;
        this.quantity = quantity;
        this.flavorWines = flavorWines;
        this.colorWines = colorWines;
        this.alcohol = alcohol;
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
        this.flagWines = flagWines;
        this.typeWines = typeWines;
    }

    public Long getIdWines() {
        return idWines;
    }

    public void setIdWines(Long idWines) {
        this.idWines = idWines;
    }

    public String getNameWines() {
        return nameWines;
    }

    public void setNameWines(String nameWines) {
        this.nameWines = nameWines;
    }

    public Double getPriceWines() {
        return priceWines;
    }

    public void setPriceWines(Double priceWines) {
        this.priceWines = priceWines;
    }

    public String getDescriptionWines() {
        return DescriptionWines;
    }

    public void setDescriptionWines(String descriptionWines) {
        DescriptionWines = descriptionWines;
    }

    public String getManufactureWines() {
        return manufactureWines;
    }

    public void setManufactureWines(String manufactureWines) {
        this.manufactureWines = manufactureWines;
    }

    public String getCountryManufacture() {
        return countryManufacture;
    }

    public void setCountryManufacture(String countryManufacture) {
        this.countryManufacture = countryManufacture;
    }

    public String getImageWines() {
        return imageWines;
    }

    public void setImageWines(String imageWines) {
        this.imageWines = imageWines;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFlavorWines() {
        return flavorWines;
    }

    public void setFlavorWines(String flavorWines) {
        this.flavorWines = flavorWines;
    }

    public String getColorWines() {
        return colorWines;
    }

    public void setColorWines(String colorWines) {
        this.colorWines = colorWines;
    }

    public Integer getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Integer alcohol) {
        this.alcohol = alcohol;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getFlagWines() {
        return flagWines;
    }

    public void setFlagWines(Double flagWines) {
        this.flagWines = flagWines;
    }

    public TypeWines getTypeWines() {
        return typeWines;
    }

    public void setTypeWines(TypeWines typeWines) {
        this.typeWines = typeWines;
    }
}
