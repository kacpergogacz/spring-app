package org.example.repositories;


import org.example.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Object> findByName(String name);

}