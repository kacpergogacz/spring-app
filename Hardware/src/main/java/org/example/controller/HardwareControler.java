package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.example.dto.company.GetHardwareDetailsResponse;
import org.example.dto.company.GetHardwareResponse;
import org.example.dto.company.GetHardwaresResponse;
import org.example.dto.company.PutHardwareRequest;
import org.example.services.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hardwares")
@RequiredArgsConstructor
public class HardwareControler {
    private final HardwareService hardwareService;


    @GetMapping
    public ResponseEntity<GetHardwaresResponse> getAllHardwares() {
        GetHardwaresResponse hardwares = hardwareService.getAllHardwares();
        return new ResponseEntity<>(hardwares, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addHardware(@RequestBody GetHardwareResponse getHardwareResponse) {
        getHardwareResponse.setHardwareId(UUID.randomUUID());
        hardwareService.addHardware(getHardwareResponse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{hardwareId}")
    public ResponseEntity<GetHardwareDetailsResponse> getHardwareById(@PathVariable UUID hardwareId){
        GetHardwareDetailsResponse hardwareDTO = hardwareService.getHardwareById(hardwareId);
        return new ResponseEntity<>(hardwareDTO,HttpStatus.OK);
    }

    @DeleteMapping("/{hardwareId}")
    public ResponseEntity<Void> deleteHardware(@PathVariable UUID hardwareId){
        boolean deleted = hardwareService.deleteHardware(hardwareId);
        if(deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else  {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{hardwareId}")
    public ResponseEntity<GetHardwareResponse> updateHardware(
            @PathVariable UUID hardwareId,
            @RequestBody PutHardwareRequest putHardwareRequest) {

        GetHardwareResponse updatedHardware = hardwareService.updateHardware(hardwareId,putHardwareRequest);
        return new ResponseEntity<>(updatedHardware,HttpStatus.OK);
    }

}
