package com.example.wines_shop.model.account;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAccount;

    private String emailAccount;

    private String password;

    @ManyToOne
    private Role role;

    public Account() {
    }

    public Account(int idAccount, String emailAccount, String password, Role role) {
        this.idAccount = idAccount;
        this.emailAccount = emailAccount;
        this.password = password;
        this.role = role;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
