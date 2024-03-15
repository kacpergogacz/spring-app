package org.example.services.impl;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.dto.GetCompaniesResponse;
import org.example.dto.GetCompanyResponse;
import org.example.dto.PutCompanyRequest;
import org.example.entities.Company;
import org.example.mapper.CompanyMapper;
import org.example.repositories.CompanyRepository;
import org.example.repositories.CompanyRestRepository;
import org.example.services.CompanyService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyRestRepository companyRestRepository;


    @Override
    public GetCompaniesResponse getAllCompanies() {
        return CompanyMapper.mapToGetCompaniesResponse(companyRepository.findAll());
    }

    @Override
    public void addCompany(GetCompanyResponse getCompanyResponse) {
        Company company = CompanyMapper.mapToCompany(getCompanyResponse);
        companyRestRepository.addCompany(getCompanyResponse);
        companyRepository.save(company);

    }


    @Override
    public boolean deleteCompany(UUID companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company== null) {
            return false;
        }
        companyRestRepository.delete(companyId);
        companyRepository.delete(company);
        return true;

    }

    @Override
    public GetCompanyResponse getCompanyById(UUID companyId) {

        Company company = companyRepository.findById(companyId).orElseThrow();
        if(company ==null){
            throw new EntityNotFoundException("Company not found");
        }
        return CompanyMapper.mapToCompanyDTO(company);
    }


    @Override
    public GetCompanyResponse updateCompany(UUID companyId, PutCompanyRequest putCompanyRequest) {
        Company company = companyRepository.findById(companyId).orElseThrow();

        company.setName(putCompanyRequest.getName());
        if(!company.getName().equalsIgnoreCase(putCompanyRequest.getName())){
            companyRestRepository.updateName(companyId,putCompanyRequest);
        }
        company.setNIP(putCompanyRequest.getNIP());
        companyRepository.save(company);
        return  CompanyMapper.mapToCompanyDTO(company);
    }


}
