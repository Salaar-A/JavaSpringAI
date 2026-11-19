package com.ecitcarp.practicespringboot.service;

import com.ecitcarp.practicespringboot.dto.UserPrincipal;
import com.ecitcarp.practicespringboot.model.User;
import com.ecitcarp.practicespringboot.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username);

        if(user == null)
            throw new UsernameNotFoundException("User Not found");

        return new UserPrincipal(user);
    }

    public User register(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }
}
