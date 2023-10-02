package com.example.wines_shop.model.discount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Discount {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idDiscount;

    private String nameDiscount;

    private Integer percentDiscount;
    private Date dateStart;
    private Date dateEnd;

    public Discount() {
    }

    public Discount(int idDiscount, String nameDiscount, Integer percentDiscount, Date dateStart, Date dateEnd) {
        this.idDiscount = idDiscount;
        this.nameDiscount = nameDiscount;
        this.percentDiscount = percentDiscount;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public int getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(int idDiscount) {
        this.idDiscount = idDiscount;
    }

    public String getNameDiscount() {
        return nameDiscount;
    }

    public void setNameDiscount(String nameDiscount) {
        this.nameDiscount = nameDiscount;
    }

    public Integer getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(Integer percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
