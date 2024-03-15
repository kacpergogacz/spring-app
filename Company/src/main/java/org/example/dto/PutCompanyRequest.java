package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutCompanyRequest {
    private String name;
    private double NIP;
}
