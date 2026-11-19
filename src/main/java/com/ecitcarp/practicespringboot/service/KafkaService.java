//package com.ecitcarp.practicespringboot.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class KafkaService {
//
//    // Send
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    // Receive
//    @KafkaListener(topics = "test")
//    public void listen(String message) {
//        log.info("Received: {}", message);
//    }
//}
