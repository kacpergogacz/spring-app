package org.example.repositories;

import org.example.dto.GetCompanyResponse;
import org.example.dto.PutCompanyRequest;

import java.util.UUID;

public interface CompanyRestRepository {
    void delete(UUID companyId);

    void updateName(UUID companyId, PutCompanyRequest putCompanyRequest);

    void addCompany(GetCompanyResponse getCompanyResponse);
}
