package com.ecitcarp.practicespringboot.filter;

import com.ecitcarp.practicespringboot.model.User;
import com.ecitcarp.practicespringboot.repo.UserRepo;
import com.ecitcarp.practicespringboot.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    private final UserRepo userRepo;

    public JWTAuthFilter(JWTService jwtService,UserRepo userRepo) {
        this.jwtService = jwtService;
        this.userRepo = userRepo;
    }

    Logger log = LoggerFactory.getLogger(JWTAuthFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("HTTP Request value {}",request);
        final String headerToken = request.getHeader("Authorization");
        if(headerToken == null){
            log.info("Inside the null header token");
            filterChain.doFilter(request,response);
            return;
        }

        String token = headerToken.split("Bearer ")[1];

        String username = jwtService.getUserNameFromToken(token);
        if(username != null){
            User user = userRepo.findByUserName(username);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, null);
            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        log.info("User name fetched from the token {}",username);
        SecurityContextHolder holder = new SecurityContextHolder();
        filterChain.doFilter(request,response);

    }
}
