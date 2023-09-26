package com.example.studentmanager.repository;

import com.example.studentmanager.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    // all the CRUD operations are implemented by default

    // we can use entities instead of SQL database tables
    @Query("select s from Status s where s.name='ACTIVE'")
    List<Status> getActiveStatus();
}
