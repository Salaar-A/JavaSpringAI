package com.ecitcarp.practicespringboot.practice;

public interface Vehicle {

    default void printHello(){
        System.out.println("Default Hello update accordingly...");
    }

    void printHi();
}


