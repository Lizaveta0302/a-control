package com.controlapp.acontrol.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private Long id;

    @Field(value = "Name")
    private String name;
}

