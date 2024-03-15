package org.example.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetHardwareCompanyNameResponse {
    private UUID hardwareId;
    private String name;
    private int cost;
    @JsonProperty("company_name")
    private String companyName;
}
