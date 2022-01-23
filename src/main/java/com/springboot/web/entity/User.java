package com.springboot.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component(value = "User")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private String password;
}
