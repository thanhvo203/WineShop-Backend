package com.example.wines_shop.model.account;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idAccount;

    private String email;

    private String password;

    @OneToOne
    @JoinColumn(name = "id_role")
    private Role idRole;

    public Account() {
    }

    public Account(Long idAccount, String email, String password, Role idRole) {
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }
}
