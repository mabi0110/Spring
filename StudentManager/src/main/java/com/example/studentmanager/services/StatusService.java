package com.example.studentmanager.services;

import com.example.studentmanager.model.Status;
import java.util.List;

public interface StatusService {
    void save(Status status);
    List<Status> findAll();
}
