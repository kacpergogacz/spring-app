package org.example.services.impl;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.dto.hardware.GetCompanyResponse;
import org.example.dto.hardware.PutCompanyRequest;
import org.example.entities.Company;
import org.example.mapper.CompanyMapper;
import org.example.repositories.CompanyRepository;
import org.example.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<GetCompanyResponse> getAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyMapper::mapToGetCompanyResponse).toList();
    }

    @Override
    public void addCompany(GetCompanyResponse getCompanyResponse) {
        Company company = CompanyMapper.mapToCompany(getCompanyResponse);
        companyRepository.save(company);

    }


    @Override
    public boolean deleteCompany(UUID uuid) {
        Company company = companyRepository.findById(uuid).orElse(null);
        if (company== null) {
            return false;
        }
        companyRepository.delete(company);
        return true;

    }

    @Override
    public GetCompanyResponse getCompanyById(UUID id) {
        return CompanyMapper.mapToGetCompanyResponse(companyRepository
                .findById(id)
                .orElseThrow());
    }


    @Override
    public GetCompanyResponse updateCompany(UUID uuid, PutCompanyRequest putCompanyRequest) {
        Company company = companyRepository.findById(uuid).orElseThrow();

        company.setName(putCompanyRequest.getName());
        companyRepository.save(company);
        return  CompanyMapper.mapToGetCompanyResponse(company);
    }


}
