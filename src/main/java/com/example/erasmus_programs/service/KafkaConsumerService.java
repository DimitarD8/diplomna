package com.example.erasmus_programs.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumerService {

    private String secretKey;

    @KafkaListener(topics = "secretKeyTopic", groupId = "jwt-consumer-group")
    public void listen(String secretKey) {
        System.out.println("The secret key is: " + secretKey);
        this.secretKey = secretKey;
    }


    public String getSecretKey() {
        return secretKey.substring(1, secretKey.length()-1);
    }
}
