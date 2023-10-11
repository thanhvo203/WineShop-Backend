package com.example.wines_shop.auth;

import com.example.wines_shop.config.JwtService;
import com.example.wines_shop.model.account.Role;
import com.example.wines_shop.model.account.Users;
import com.example.wines_shop.repository.UserRepository;
import com.example.wines_shop.service.IRoleService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final IRoleService iRoleService;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = Users.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .idRole(iRoleService.findByName("ROLE_USER").get())
                .build();
        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        Users user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("users",user.getFullName());
        hashMap.put("id",user.getIdAccount());
        var jwtToken = jwtService.generateToken(hashMap,user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
