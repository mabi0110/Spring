package com.example.streamapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Jan", "Nowak", 25, List.of("Java", "Python"));
        Employee employee2 = new Employee("Ala", "Nowak", 21, List.of("Java", "C++"));
        Employee employee3 = new Employee("Ela", "Nowak", 20, List.of("Java", "C#"));
        Employee employee4 = new Employee("Ula", "Nowak", 19, List.of("Java"));
        Employee employee5 = new Employee("Piotr", "Nowak", 28, List.of("Java", "Golang"));
        Employee employee6 = new Employee("Adam", "Nowak", 45, List.of("Java", "Rust"));
        Employee employee7 = new Employee("Ewa", "Nowak", 35, List.of("Java", "Scala"));
        Employee employee8 = new Employee("Ola", "Nowak", 46, List.of("Java", "Kotlin"));
        Employee employee9 = new Employee("Anna", "Nowak", 42, List.of("Java", "JavaScript"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
        employees.add(employee9);

    }

    @Test
    public void firstStream(){
        employees.forEach(System.out::println);
    }

    @Test
    public void mapOperation() {
        employees.stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    @Test
    public void mapOperation2() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }

    @Test
    public void flatMapOperation() {
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());

        System.out.println(allSkills);
    }

    @Test
    public void flatMapOperation2() {
        List<String> allSkills = employees.stream()
                .map(Employee::getSkills)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(allSkills);
    }

    @Test
    public void filterOperation() {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("O"))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOperation2() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .forEach(System.out::println);
    }


    @Test
    public void limitOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperation(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void countOperation(){
        long numberOfEmployees = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("A"))
                .count();
        System.out.println(numberOfEmployees);
    }

    @Test
    public void minMaxOperation() {
        Employee youngetEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge))
                .get();
        System.out.println(youngetEmployee);
    }

    @Test
    public void findFirstOperation() {
        Employee employee = employees.stream()
                .filter(e -> e.getFirstName().startsWith("A"))
                .findFirst()
                .get();
        System.out.println(employee);
    }

    @Test
    public void findAnyOperation() {
        Employee employee = employees.stream()
                .filter(e -> e.getFirstName().startsWith("A"))
                .findAny()
                .get();
        System.out.println(employee);
    }

    @Test
    public void matchOperation() {
        boolean a = employees.stream()
                .allMatch(e -> e.getFirstName().contains("A"));
        System.out.println(a);
    }

    @Test
    public void matchOperation1() {
        boolean a = employees.stream()
                .anyMatch(e -> e.getFirstName().contains("A"));
        System.out.println(a);
    }

    @Test
    public void matchOperation2() {
        boolean a = employees.stream()
                .noneMatch(e -> e.getFirstName().startsWith("Z"));
        System.out.println(a);
    }

    @Test
    public void reduceOperation(){
        Integer sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum)
                .get();
        System.out.println(sumOfAllAges);
    }

    @Test
    public void reduceOperation1(){
        int sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sumOfAllAges);
    }

    @Test
    public void reduceOperation2(){
        String allNames = employees.stream()
                .map(Employee::getFirstName)
                .reduce((n1, n2) -> n1 + " - " + n2)
                .get();
        System.out.println(allNames);
    }

    @Test
    public void takeWhileOperation(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrderedOperation(){
        String sentence = "Jak nauczyc sie programowania";
        sentence.chars().forEach(s -> System.out.println((char) s));
        System.out.println();
        sentence.chars().parallel().forEach(s -> System.out.println((char) s));
        System.out.println();
        sentence.chars().parallel().forEachOrdered(s -> System.out.println((char) s));
        System.out.println();
    }

    @Test
    public void peekOperation(){
        List<Employee> newEmployees = employees.stream()
                .peek(e -> e.setFirstName("Kamil"))
                .collect(Collectors.toList());
        System.out.println(newEmployees);
        System.out.println(employees);
    }








}
