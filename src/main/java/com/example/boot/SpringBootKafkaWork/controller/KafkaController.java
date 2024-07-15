package com.example.boot.SpringBootKafkaWork.controller;

import com.example.boot.SpringBootKafkaWork.kafka.KafkaProducer;
import com.example.boot.SpringBootKafkaWork.model.KafkaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//First run Zookeeper and Broker command in cmd and then run the application

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private  KafkaProducer kafkaProducer;

    //http://localhost:8182/api/kafka/publish?message=Second%20Topic%20Data
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody KafkaUser user){

        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message send to the topic");
    }
}
