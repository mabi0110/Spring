package com.example.walidacja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WalidacjaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WalidacjaApplication.class, args);
        PersonService personService = context.getBean(PersonService.class);
        Person person1 = new Person("Jan", "Nowak", "jan@gmail.com", 34);
        System.out.println("Adding " + person1);
        personService.addPerson(person1);

        Person person2 = new Person("Ala", null, "ala@gmail.com", 12);
        System.out.println("Adding " + person2);
        personService.addPerson(person2);

        Person person3 = new Person("Ola", "Nowak", "ola", 0);
        System.out.println("Adding " + person3);
        personService.addPerson(person3);

        System.out.println(personService);
    }

}
