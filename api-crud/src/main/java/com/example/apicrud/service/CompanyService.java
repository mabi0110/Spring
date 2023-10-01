package com.example.apicrud.service;

import com.example.apicrud.dto.CompanyDto;
import com.example.apicrud.dto.CompanyJobOfferDto;
import com.example.apicrud.mapper.CompanyDtoMapper;
import com.example.apicrud.mapper.CompanyJobOfferDtoMapper;
import com.example.apicrud.model.Company;
import com.example.apicrud.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyDtoMapper companyDtoMapper;
    private final CompanyJobOfferDtoMapper companyJobOfferDtoMapper;

    public CompanyService(CompanyRepository companyRepository, CompanyDtoMapper companyDtoMapper, CompanyJobOfferDtoMapper companyJobOfferDtoMapper) {
        this.companyRepository = companyRepository;
        this.companyDtoMapper = companyDtoMapper;
        this.companyJobOfferDtoMapper = companyJobOfferDtoMapper;
    }

    public Optional<CompanyDto> getCompanyById(Long id) {
        return companyRepository.findById(id).map(companyDtoMapper::map);
    }

    public List<CompanyJobOfferDto> getJobOffersByCompanyId(Long id){
        return companyRepository.findById(id)
                .map(Company::getJobOffers)
                .orElse(Collections.emptyList())
                .stream()
                .map(companyJobOfferDtoMapper::map)
                .toList();

    }

    public CompanyDto saveCompany(CompanyDto companyDto){
        Company company = companyDtoMapper.map(companyDto);
        Company savedCompany = companyRepository.save(company);
        return companyDtoMapper.map(savedCompany);
    }

    public Optional<CompanyDto> replaceCompany(Long companyId, CompanyDto companyDto){
        if(!companyRepository.existsById(companyId)){
            return Optional.empty();
        }
        companyDto.setId(companyId);
        Company companyToUpdate = companyDtoMapper.map(companyDto);
        Company updatedCompany = companyRepository.save(companyToUpdate);
        return Optional.of(companyDtoMapper.map(updatedCompany));
    }


}
