package com.example.onetoone;

import org.springframework.data.repository.CrudRepository;

interface ClientRepository extends CrudRepository<Client, Long> {
}
