package org.example.repositories.impl;

import org.example.config.CompanyRestApiUrl;
import org.example.dto.GetCompanyResponse;
import org.example.dto.PutCompanyRequest;
import org.example.repositories.CompanyRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Repository
public class CompanyRestRepositoryImpl implements CompanyRestRepository {

    private final RestTemplate restTemplate;
    private final CompanyRestApiUrl companyRestApiUrl;

    @Autowired
    public CompanyRestRepositoryImpl(RestTemplate restTemplate, CompanyRestApiUrl companyRestApiUrl) {
        this.restTemplate = restTemplate;
        this.companyRestApiUrl = companyRestApiUrl;
    }

    @Override
    public void delete(UUID companyId) {
        restTemplate.delete(companyRestApiUrl.getDeleteUrl(),companyId);
    }

    @Override
    public void updateName(UUID companyId, PutCompanyRequest putCompanyRequest) {
        String url = UriComponentsBuilder.fromUriString(companyRestApiUrl.getPutUrl())
                .pathSegment("{companyId}")
                .buildAndExpand(companyId)
                .toUriString();

        restTemplate.put(url,putCompanyRequest);
    }

    @Override
    public void addCompany(GetCompanyResponse getCompanyResponse) {
        restTemplate.postForLocation(companyRestApiUrl.getPostUrl(),getCompanyResponse);
    }
}
