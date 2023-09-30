package com.example.apicrud;

import com.example.apicrud.dto.JobOfferDto;
import com.example.apicrud.mapper.JobOfferDtoMapper;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final JobOfferDtoMapper jobOfferDtoMapper;
    public JobOfferService(JobOfferRepository jobOfferRepository, JobOfferDtoMapper jobOfferDtoMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.jobOfferDtoMapper = jobOfferDtoMapper;
    }

    Optional<JobOfferDto> getOfferById(Long id){
        return jobOfferRepository.findById(id).map(jobOfferDtoMapper::map);
    }
}
