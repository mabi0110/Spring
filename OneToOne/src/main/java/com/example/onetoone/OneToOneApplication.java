package com.example.onetoone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class OneToOneApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(OneToOneApplication.class, args);
        UserDetails userDetails = new UserDetails("Jan", "Kowalski", "Wrocław, 50-503, ul. Legnicka 32/16");
        UserDetailsRepository userDetailsRepository = context.getBean(UserDetailsRepository.class);
        userDetailsRepository.save(userDetails);

        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = new User("johnkowal", "strongpassword1", "johnkowal@example.com", userDetails);
        userRepository.save(user);

        Optional<User> firstUser = userRepository.findById(1L);
        System.out.println("Informacje o pierwszym użytkowniku:");
        firstUser.ifPresent(System.out::println);
        System.out.println("Szczegóły pierwszego użytkownika:");
        firstUser.map(User::getUserDetails).ifPresent(System.out::println);
    }

}
