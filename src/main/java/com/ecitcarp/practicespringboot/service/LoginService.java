package com.ecitcarp.practicespringboot.service;

import com.ecitcarp.practicespringboot.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final JWTService jwtService;

    public LoginService(AuthenticationManager authenticationManager,JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String validateLogin(User user){

        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(auth.isAuthenticated())
            return jwtService.generateToken(user);
        else
            throw new UsernameNotFoundException("User Not Found");
    }
}
