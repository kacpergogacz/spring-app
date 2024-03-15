package org.example.mapper;


import lombok.Builder;
import org.example.dto.GetCompaniesResponse;
import org.example.dto.GetCompanyResponse;
import org.example.entities.Company;

import java.util.List;


@Builder

public class CompanyMapper {

    public static Company mapToCompany(GetCompanyResponse getCompanyResponse) {
        return Company.builder()
                .companyId(getCompanyResponse.getCompanyId())
                .name(getCompanyResponse.getName())
                .NIP(getCompanyResponse.getNIP())
                .build();
       
    }

    public static GetCompanyResponse mapToCompanyDTO(Company company) {
        return GetCompanyResponse.builder()
                .companyId(company.getCompanyId())
                .name(company.getName())
                .NIP(company.getNIP())
                .build();
    }

    public static GetCompaniesResponse mapToGetCompaniesResponse(List<Company> companies){
        return GetCompaniesResponse.builder()
                .companies(companies.stream()
                        .map(CompanyMapper::mapToCompanyDTO)
                        .toList())
                .build();

    }



}
