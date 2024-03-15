package org.example.services;

import org.example.dto.company.GetHardwareDetailsResponse;
import org.example.dto.company.GetHardwareResponse;
import org.example.dto.company.GetHardwaresResponse;
import org.example.dto.company.PutHardwareRequest;

import java.util.UUID;


public interface HardwareService {
    GetHardwaresResponse getAllHardwares();

    void addHardware(GetHardwareResponse getHardwareResponse);

    boolean deleteHardware(UUID uuid);

    GetHardwareDetailsResponse getHardwareById(UUID id);

    GetHardwareResponse updateHardware(UUID uuid, PutHardwareRequest putHardwareRequest);
}
