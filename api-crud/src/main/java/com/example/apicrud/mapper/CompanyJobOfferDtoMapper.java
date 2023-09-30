package com.example.apicrud.mapper;

import com.example.apicrud.dto.CompanyJobOfferDto;
import com.example.apicrud.model.JobOffer;
import org.springframework.stereotype.Service;

@Service
public class CompanyJobOfferDtoMapper {

    public CompanyJobOfferDto map(JobOffer jobOffer) {
        CompanyJobOfferDto dto = new CompanyJobOfferDto();
        dto.setId(jobOffer.getId());
        dto.setTitle(jobOffer.getTitle());
        dto.setLocation(jobOffer.getLocation());
        dto.setMinSalary(jobOffer.getMinSalary());
        dto.setMaxSalary(jobOffer.getMaxSalary());
        return dto;
    }
}
