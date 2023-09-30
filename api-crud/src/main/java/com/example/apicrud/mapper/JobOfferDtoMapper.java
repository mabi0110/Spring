package com.example.apicrud.mapper;

import com.example.apicrud.dto.CompanyDto;
import com.example.apicrud.dto.JobOfferDto;
import com.example.apicrud.model.JobOffer;
import org.springframework.stereotype.Service;

@Service
public class JobOfferDtoMapper {

    public JobOfferDto map(JobOffer jobOffer){
        JobOfferDto dto = new JobOfferDto();
        dto.setId(jobOffer.getId());
        dto.setTitle(jobOffer.getTitle());
        dto.setDescription(jobOffer.getDescription());
        dto.setRequirements(jobOffer.getRequirements());
        dto.setDuties(jobOffer.getDuties());
        dto.setLocation(jobOffer.getLocation());
        dto.setMinSalary(jobOffer.getMinSalary());
        dto.setMaxSalary(jobOffer.getMaxSalary());
        dto.setDateAdded(jobOffer.getDateAdded());
        dto.setCompanyDto(new CompanyDto(jobOffer.getCompany().getId(), jobOffer.getCompany().getName()));
        return dto;
    }
}
