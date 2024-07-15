package com.example.boot.SpringBootKafkaWork.kafka;

import com.example.boot.SpringBootKafkaWork.model.KafkaUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    //By using Kafka Template Producer send the msg to kafka

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){

        LOGGER.info(String.format("Message sent is -> %s" , message));
        kafkaTemplate.send("second",message);

    }

    public void sendMessage(KafkaUser user){

        LOGGER.info(String.format("JSON Message sent is -> %s", user.toString()));

        Message<KafkaUser> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "second_json")
                .build();

        kafkaTemplate.send(message);
    }
}
