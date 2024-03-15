package org.example.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.dto.hardware.GetCompanyResponse;
import org.example.dto.hardware.PutCompanyRequest;
import org.example.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping
    public ResponseEntity<Void> addNewCompany(@RequestBody GetCompanyResponse getCompanyResponse) {

        getCompanyResponse.setCompanyId(UUID.randomUUID());
        companyService.addCompany(getCompanyResponse);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{companyId}")
    public ResponseEntity<GetCompanyResponse> updateCompany(
            @PathVariable UUID companyId,
            @RequestBody PutCompanyRequest putCompanyRequest
    ) {
        try {
            GetCompanyResponse updatedCompany = companyService.updateCompany(companyId, putCompanyRequest);
            return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<GetCompanyResponse>> getAllCompanies() {

        List<GetCompanyResponse> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }


    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable UUID companyId) {
        boolean checkIfDeleted = companyService.deleteCompany(companyId);
        if (checkIfDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
