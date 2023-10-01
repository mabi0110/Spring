package com.example.apicrud.service;

import com.example.apicrud.dto.JobOfferDto;
import com.example.apicrud.mapper.JobOfferDtoMapper;
import com.example.apicrud.model.JobOffer;
import com.example.apicrud.repository.JobOfferRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final JobOfferDtoMapper jobOfferDtoMapper;
    public JobOfferService(JobOfferRepository jobOfferRepository, JobOfferDtoMapper jobOfferDtoMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDtoMapper = jobOfferDtoMapper;
    }

    public Optional<JobOfferDto> getOfferById(Long id){
        return jobOfferRepository.findById(id).map(jobOfferDtoMapper::map);
    }

    public JobOfferDto saveOffer(JobOfferDto jobOfferDto){
        JobOffer jobOfferToSave = jobOfferDtoMapper.map(jobOfferDto);
        jobOfferToSave.setDateAdded(LocalDateTime.now());
        JobOffer savedJobOffer = jobOfferRepository.save(jobOfferToSave);
        return jobOfferDtoMapper.map(savedJobOffer);
    }
}
