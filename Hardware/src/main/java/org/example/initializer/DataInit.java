package org.example.initializer;


import jakarta.annotation.PostConstruct;
import org.example.entities.Company;
import org.example.entities.Hardware;
import org.example.repositories.CompanyRepository;
import org.example.repositories.HardwareRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DataInit {

    private final CompanyRepository companyRepository;
    private final HardwareRepository hardwareRepository;


    public DataInit(CompanyRepository companyRepository, HardwareRepository hardwareRepository) {
        this.companyRepository = companyRepository;
        this.hardwareRepository = hardwareRepository;
    }

    @PostConstruct
    public void dataInit() {

        List<Company> companyList = DataInit.initCompanies();
        companyRepository.saveAll(companyList);
        List<Hardware> hardwareList = initHardwares(companyList);
        hardwaresToCompanies(companyList,hardwareList);
        hardwareRepository.saveAll(hardwareList);
        companyRepository.saveAll(companyList);


    }
    public void hardwaresToCompanies(List<Company> companies, List<Hardware> hardwares) {
        companies.get(0).setHardwares(Arrays.asList(hardwares.get(0),hardwares.get(1)));
        companies.get(1).setHardwares(Arrays.asList(hardwares.get(2),hardwares.get(3)));
        companies.get(2).setHardwares(Arrays.asList(hardwares.get(4),hardwares.get(5)));
        companies.get(3).setHardwares(Arrays.asList(hardwares.get(6)));
    }
    public List<Hardware> initHardwares(List<Company> companies) {
        List<Hardware> hardwareList = new ArrayList<>();

        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("b04aff00-176f-4ab8-978f-e7f201d64603"))
                .name("Monitor LED")
                .cost(24)
                .company(companies.get(0))
                .build());
        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("dcc5240b-c035-4afb-a1f4-bc530edfa599"))
                .name("Hard Drive")
                .cost(120)
                .company(companies.get(0))
                .build());
        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("f6277d96-b894-4c0c-8dd8-3c1f65069e3a"))
                .name("Keyboard")
                .cost(30)
                .company(companies.get(1))
                .build());
        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("be8d753c-d818-41b2-b670-db0f705237f2"))
                .name("Mouse")
                .cost(96)
                .company(companies.get(1))
                .build());
        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("5d82eb26-0759-471f-9e24-3038f37bc3d7"))
                .name("Graphics Card v1")
                .cost(101)
                .company(companies.get(2))
                .build());
        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("262cce12-66f9-4ec2-91b1-4af1d6cd5bf5"))
                .name("Graphics Card v2")
                .cost(78)
                .company(companies.get(2))
                .build());
        hardwareList.add(Hardware.builder().hardwareId(UUID.fromString("83bd6ad7-4291-410c-9781-00e7c9c44091"))
                .name("Monitor")
                .cost(23)
                .company(companies.get(3))
                .build());

        return hardwareList;
    }
    public static List<Company> initCompanies() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(Company.builder().companyId(UUID.fromString("5c535054-7e94-46b3-b68a-2d805a17d9e7"))
                .name("LEGION").build());
        companyList.add(Company.builder().companyId(UUID.fromString("68247315-d423-476d-b79d-21f5d0ce37ad"))
                .name("ASUS").build());
        companyList.add(Company.builder().companyId(UUID.fromString("1331fcca-dfa7-4a78-96d3-5e20634486bb"))
                .name("DELL").build());
        companyList.add(Company.builder().companyId(UUID.fromString("bcb2f636-2d58-42e2-ac2f-8490d1099435"))
                .name("NVIDIA").build());

        return companyList;
    }


}
