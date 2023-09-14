package com.example.validation;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    boolean existsByUserName(String userName);
}
