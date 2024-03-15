package org.example.services.impl;


import lombok.RequiredArgsConstructor;
import org.example.dto.company.GetHardwareDetailsResponse;
import org.example.dto.company.GetHardwareResponse;
import org.example.dto.company.GetHardwaresResponse;
import org.example.dto.company.PutHardwareRequest;
import org.example.entities.Company;
import org.example.entities.Hardware;
import org.example.mapper.HardwareMapper;
import org.example.repositories.CompanyRepository;
import org.example.repositories.HardwareRepository;
import org.example.services.HardwareService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HardwareServiceImpl implements HardwareService {
    private final HardwareRepository hardwareRepository;
    private final CompanyRepository companyRepository;


    @Override
    public GetHardwaresResponse getAllHardwares() {
        List<Hardware> hardwareList = hardwareRepository.findAll();
        return HardwareMapper.mapToGetHardwaresResponse(hardwareList);
    }

    @Override
    public void addHardware(GetHardwareResponse getHardwareResponse) {
        Company company = companyRepository.findById(getHardwareResponse.getCompanyId()).orElseThrow();
        Hardware hardware = HardwareMapper.mapToHardware(getHardwareResponse,company);
        hardwareRepository.save(hardware);

    }

    @Override
    public boolean deleteHardware(UUID uuid) {

        Hardware hardware = hardwareRepository.findById(uuid).orElse(null);
        if(hardware == null){
            return false;
        }
        else{
            hardwareRepository.delete(hardware);
        }
        return true;
    }

    @Override
    public GetHardwareDetailsResponse getHardwareById(UUID hardwareId) {
        Hardware hardware = hardwareRepository.findById(hardwareId).orElseThrow();
        return HardwareMapper.mapToGetHardwareDTO(hardware);
    }

    @Override
    public GetHardwareResponse updateHardware(UUID uuid, PutHardwareRequest putHardwareRequest) {
        Hardware existingHardware = hardwareRepository.findById(uuid).orElseThrow();
        existingHardware.setName(putHardwareRequest.getName());
        existingHardware.setCost(putHardwareRequest.getCost());
        //Company company = companyRepository.findById(putHardwareRequest.getCompanyId()).orElseThrow();
        //existingHardware.setCompany(company);
        hardwareRepository.save(existingHardware);

        return HardwareMapper.mapToHardwareDTO(existingHardware);
    }


}
