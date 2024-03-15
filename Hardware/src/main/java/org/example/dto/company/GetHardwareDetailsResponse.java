package org.example.dto.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.example.dto.hardware.GetCompanyResponse;

import java.util.UUID;

@Data
@Builder
public class GetHardwareDetailsResponse {
    private UUID hardwareId;
    private String name;
    private int cost;
    @JsonProperty("company")
    private GetCompanyResponse company;
}
