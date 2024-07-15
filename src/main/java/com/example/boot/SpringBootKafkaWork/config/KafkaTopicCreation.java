package com.example.boot.SpringBootKafkaWork.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicCreation {

    @Bean
    public NewTopic createTopic(){

        return TopicBuilder.name("second")
                .build();
    }

    @Bean
    public NewTopic createJsonTopic(){

        return TopicBuilder.name("second_json")
                .build();
    }
}
