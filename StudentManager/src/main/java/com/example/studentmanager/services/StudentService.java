package com.example.studentmanager.services;

import com.example.studentmanager.model.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);
    void remove(Student student);
    List<Student> findAll();
    List<Student> find(String substring);


}
