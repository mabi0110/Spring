package com.example.studentmanager.repository;

import com.example.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where lower(s.name) like lower(concat('%', :substring, '%'))")
    List<Student> findStudents(String substring);
}
