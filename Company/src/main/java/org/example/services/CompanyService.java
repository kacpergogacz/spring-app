package org.example.services;

import org.example.dto.GetCompaniesResponse;
import org.example.dto.GetCompanyResponse;
import org.example.dto.PutCompanyRequest;

import java.util.UUID;

public interface CompanyService {
    GetCompaniesResponse getAllCompanies();

    void addCompany(GetCompanyResponse getCompanyResponse);

    boolean deleteCompany(UUID uuid);

    GetCompanyResponse getCompanyById(UUID id);

    GetCompanyResponse updateCompany(UUID uuid, PutCompanyRequest putCompanyRequest);

}
