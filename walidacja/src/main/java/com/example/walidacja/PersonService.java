package com.example.walidacja;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {
    private final Set<Person> people = new HashSet<>();

    private final Validator validator;


    public PersonService(Validator validator) {
        this.validator = validator;
    }

    public void addPerson(Person person) {
        Set<ConstraintViolation<Person>> errors = validator.validate(person);
        if (!errors.isEmpty()) {
            System.out.println("Nie można dodać obiektu");
            System.out.println("Lista błędów:");
            errors.forEach(err-> System.out.printf("> %s %s (%s)\n",
                    err.getPropertyPath(),
                    err.getMessage(),
                    err.getInvalidValue()));
        } else {
            people.add(person);
            System.out.println("Obiekt został dodany");
        }
    }

    @Override
    public String toString() {
        String result = "People size: " + people.size() + "\n";
        for (Person person : people) {
            result = result + person + "\n";
        }
        return result;
    }
}
