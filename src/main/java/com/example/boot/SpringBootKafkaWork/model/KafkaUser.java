package com.example.boot.SpringBootKafkaWork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaUser {

    private int id;
    private String firstName;
    private String lastName;


}
