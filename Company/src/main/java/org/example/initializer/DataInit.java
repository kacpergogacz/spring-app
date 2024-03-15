package org.example.initializer;


import jakarta.annotation.PostConstruct;
import org.example.entities.Company;
import org.example.repositories.CompanyRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DataInit  {

    private final CompanyRepository companyRepository;


    public DataInit(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;

    }

    private static List<Company> initCompanies() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(Company.builder().companyId(UUID.fromString("5c535054-7e94-46b3-b68a-2d805a17d9e7"))
                .name("LEGION").NIP(21312321).build());
        companyList.add(Company.builder().companyId(UUID.fromString("68247315-d423-476d-b79d-21f5d0ce37ad"))
                .name("ASUS").NIP(15756657).build());
        companyList.add(Company.builder().companyId(UUID.fromString("1331fcca-dfa7-4a78-96d3-5e20634486bb"))
                .name("DELL").NIP(30232133).build());
        companyList.add(Company.builder().companyId(UUID.fromString("bcb2f636-2d58-42e2-ac2f-8490d1099435"))
                .name("NVIDIA").NIP(10123123).build());

        return companyList;
    }

    @PostConstruct
    public void dataInit() {

        List<Company> companyList = DataInit.initCompanies();
        companyRepository.saveAll(companyList);


    }
}
