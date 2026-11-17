package com.ecitcarp.practicespringboot.service;


import com.ecitcarp.practicespringboot.model.User;
import com.ecitcarp.practicespringboot.model.UserModelTest;
import com.ecitcarp.practicespringboot.repo.UserRepo;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserService userService;


    @Test
    void loadUserByUsernameTest(){
        Mockito.when(userRepo.findByUserName("Test")).thenReturn(UserModelTest.createUser());

        UserDetails userDetails = userService.loadUserByUsername("Test");

        Assertions.assertEquals("Test", userDetails.getUsername());
//        Assert()
    }
}
