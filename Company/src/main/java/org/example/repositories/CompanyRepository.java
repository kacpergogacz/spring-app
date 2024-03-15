package org.example.repositories;


import org.example.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CompanyRepository extends JpaRepository<Company, UUID> {
    @Override
    List<Company> findAll();
    @Override
    Optional<Company> findById(UUID companyId);
    Company findByName(String companyName);
}