package com.ecitcarp.practicespringboot.repo;

import com.ecitcarp.practicespringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
