package com.example.userbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserbaseApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(UserbaseApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);
        userRepository.save(new User("Jan", "Nowak", 25));
        userRepository.save(new User("Ula", "Nowak", 46));
        userRepository.save(new User("Ela", "Nowak", 45));
    }

}
