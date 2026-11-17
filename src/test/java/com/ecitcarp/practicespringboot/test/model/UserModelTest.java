package com.ecitcarp.practicespringboot.model;

public class UserModelTest {

    public static User createUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("Test");
        user.setPassword("Test@123");
        user.setRole("USER");
        return user;
    }
}
