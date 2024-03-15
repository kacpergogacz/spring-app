package org.example.mapper;



import org.example.dto.hardware.GetCompanyResponse;
import org.example.entities.Company;

import java.util.List;




public class CompanyMapper {

    public static Company mapToCompany(GetCompanyResponse getCompanyResponse) {
        return Company.builder()
                .companyId(getCompanyResponse.getCompanyId())
                .name(getCompanyResponse.getName())
                .build();
       
    }

    public static GetCompanyResponse mapToGetCompanyResponse(Company company) {
        return GetCompanyResponse.builder()
                .companyId(company.getCompanyId())
                .name(company.getName())
                .build();
    }





}
