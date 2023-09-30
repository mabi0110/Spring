package com.example.apicrud;

import com.example.apicrud.model.JobOffer;
import org.springframework.data.repository.CrudRepository;

public interface JobOfferRepository extends CrudRepository<JobOffer, Long> {
}
