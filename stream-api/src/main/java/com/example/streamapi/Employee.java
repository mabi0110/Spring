package com.example.streamapi;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private int age;

    private List<String> skills;


}
