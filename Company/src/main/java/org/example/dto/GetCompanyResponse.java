package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetCompanyResponse {
    private UUID companyId;
    private String name;
    private double NIP;
}
