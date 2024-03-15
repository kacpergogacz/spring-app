package org.example.mapper;


import org.example.dto.company.GetHardwareDetailsResponse;
import org.example.dto.company.GetHardwareResponse;
import org.example.dto.company.GetHardwaresResponse;
import org.example.entities.Company;
import org.example.entities.Hardware;

import java.util.List;

public class HardwareMapper {

    public static Hardware mapToHardware(GetHardwareResponse getHardwareResponse, Company company) {
        return Hardware.builder()
                .hardwareId(getHardwareResponse.getHardwareId())
                .company(company)
                .name(getHardwareResponse.getName())
                .cost(getHardwareResponse.getCost())
                .build();

    }

    public static GetHardwareResponse mapToHardwareDTO(Hardware hardware) {
        return GetHardwareResponse.builder()
                .companyId(hardware.getCompany().getCompanyId())
                .hardwareId(hardware.getHardwareId())
                .name(hardware.getName())
                .cost(hardware.getCost())
                .build();
    }

    public static GetHardwareDetailsResponse mapToGetHardwareDTO(Hardware hardware) {
        return GetHardwareDetailsResponse.builder()
                .company(CompanyMapper.mapToGetCompanyResponse(hardware.getCompany()))
                .hardwareId(hardware.getHardwareId())
                .name(hardware.getName())
                .cost(hardware.getCost())
                .build();
    }

    public static GetHardwaresResponse mapToGetHardwaresResponse(List<Hardware> hardwares) {
        return GetHardwaresResponse.builder()
                .hardwares(hardwares.stream()
                        .map(HardwareMapper::mapToHardwareDTO)
                        .toList())
                .build();
    }


}
