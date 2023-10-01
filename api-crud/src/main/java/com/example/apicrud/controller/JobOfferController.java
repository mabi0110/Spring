package com.example.apicrud.controller;

import com.example.apicrud.dto.JobOfferDto;
import com.example.apicrud.service.JobOfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/offers")
public class JobOfferController {


    private final JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping("/{id}")
    ResponseEntity<JobOfferDto> getOfferById(@PathVariable Long id){
        return jobOfferService.getOfferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<JobOfferDto> saveOffer(@RequestBody JobOfferDto jobOfferDto){
        JobOfferDto savedJobOffer = jobOfferService.saveOffer(jobOfferDto);

        URI savedJobOfferUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedJobOffer.getId())
                .toUri();

        return ResponseEntity.created(savedJobOfferUri).body(savedJobOffer);

    }


    // 1. POST /companies/1/offers
    // 2.
    // 2.1 POST /companies
    // 2.2 POST /offers
    // 2.3 PUT /offers/5
    // 3. POST /offers
}
