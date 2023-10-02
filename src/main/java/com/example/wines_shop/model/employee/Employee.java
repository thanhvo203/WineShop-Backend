package com.example.wines_shop.model.employee;

import com.example.wines_shop.model.account.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmployee;

    private String nameEmployee;
    private String addressEmployee;
    private String telEmployee;
    private String emailEmployee;
    private Date dayOfBirth;

    private String genderEmployee;

    private Boolean flagEmployee;
    @OneToOne
    private Account account;

    public Employee() {
    }

    public Employee(int idEmployee, String nameEmployee, String addressEmployee, String telEmployee, String emailEmployee, Date dayOfBirth, String genderEmployee, Boolean flagEmployee, Account account) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.addressEmployee = addressEmployee;
        this.telEmployee = telEmployee;
        this.emailEmployee = emailEmployee;
        this.dayOfBirth = dayOfBirth;
        this.genderEmployee = genderEmployee;
        this.flagEmployee = flagEmployee;
        this.account = account;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getTelEmployee() {
        return telEmployee;
    }

    public void setTelEmployee(String telEmployee) {
        this.telEmployee = telEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGenderEmployee() {
        return genderEmployee;
    }

    public void setGenderEmployee(String genderEmployee) {
        this.genderEmployee = genderEmployee;
    }

    public Boolean getFlagEmployee() {
        return flagEmployee;
    }

    public void setFlagEmployee(Boolean flagEmployee) {
        this.flagEmployee = flagEmployee;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
