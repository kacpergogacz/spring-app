package org.example.services;

import org.example.dto.hardware.GetCompanyResponse;
import org.example.dto.hardware.PutCompanyRequest;

import java.util.List;
import java.util.UUID;

public interface CompanyService {
    List<GetCompanyResponse> getAllCompanies();

    void addCompany(GetCompanyResponse getCompanyResponse);

    boolean deleteCompany(UUID uuid);

    GetCompanyResponse getCompanyById(UUID id);

    GetCompanyResponse updateCompany(UUID uuid, PutCompanyRequest putCompanyRequest);

}
