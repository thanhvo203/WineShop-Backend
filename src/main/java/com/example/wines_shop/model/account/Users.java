package com.example.wines_shop.model.account;


import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "account")
public class Users implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idAccount;
    private String fullName;

    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role idRole;

    public Users() {
    }

    public Users(Long idAccount, String email, String password, Role idRole) {
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public Users(Long idAccount, String fullName, String email, String password, Role idRole) {
        this.idAccount = idAccount;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(idRole.getNameRole());
        return List.of(new SimpleGrantedAuthority(idRole.getNameRole()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
