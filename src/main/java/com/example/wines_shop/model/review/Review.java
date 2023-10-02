package com.example.wines_shop.model.review;

import com.example.wines_shop.model.account.Account;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReview;

    private Double rating;

    private Boolean flagReview;
    @ManyToOne
    private Account account;

    public Review() {
    }

    public Review(int idReview, Double rating, Boolean flagReview, Account account) {
        this.idReview = idReview;
        this.rating = rating;
        this.flagReview = flagReview;
        this.account = account;
    }

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getFlagReview() {
        return flagReview;
    }

    public void setFlagReview(Boolean flagReview) {
        this.flagReview = flagReview;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
