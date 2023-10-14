package com.example.wines_shop.model.customer;

import com.example.wines_shop.model.account.Users;
import lombok.Builder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    private String nameCustomer;
    private String addressCustomer;
    private String emailCustomer;
    private String telCustomer;
    private String genderCustomer;
    @Temporal(TemporalType.DATE)
    private Date dayOfBirth;
    private Boolean flagCustomer;

    @OneToOne
    @JoinColumn(name = "id_account")
    private Users idUsers;


    public Customer() {
    }

    public Customer(Long idCustomer, String nameCustomer, String addressCustomer, String emailCustomer, String telCustomer, String genderCustomer, Date dayOfBirth, Boolean flagCustomer, Users users) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.emailCustomer = emailCustomer;
        this.telCustomer = telCustomer;
        this.genderCustomer = genderCustomer;
        this.dayOfBirth = dayOfBirth;
        this.flagCustomer = flagCustomer;
        this.idUsers = users;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getTelCustomer() {
        return telCustomer;
    }

    public void setTelCustomer(String telCustomer) {
        this.telCustomer = telCustomer;
    }

    public String getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(String genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Boolean getFlagCustomer() {
        return flagCustomer;
    }

    public void setFlagCustomer(Boolean flagCustomer) {
        this.flagCustomer = flagCustomer;
    }

    public Users getAccount() {
        return idUsers;
    }

    public void setAccount(Users users) {
        this.idUsers = users;
    }
}
