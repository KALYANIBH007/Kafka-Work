package com.example.boot.SpringBootKafkaWork.kafka;

import com.example.boot.SpringBootKafkaWork.model.KafkaUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    //By using Kafka Listener Consumer receive the msg from kafka
    @KafkaListener(topics = "second", groupId = "myConsumerGrp")
    public void receiveMessage(String message){

        LOGGER.info(String.format("Message received is -> %s ", message));
    }

    @KafkaListener(topics = "second_json", groupId = "myConsumerGrp")
    public void receiveJsonMessage(KafkaUser user){

        LOGGER.info(String.format("JSON Message receive is -> %s", user.toString()));
    }
}
