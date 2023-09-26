package com.example.studentmanager.services;

import com.example.studentmanager.model.Status;
import com.example.studentmanager.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void save(Status status) {
        statusRepository.save(status);
    }

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
