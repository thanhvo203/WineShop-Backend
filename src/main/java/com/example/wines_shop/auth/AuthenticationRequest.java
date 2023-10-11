package com.example.wines_shop.auth;

import com.example.wines_shop.model.account.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String fullName;
    private String email;
    private String password;

}
