package org.example.dto.company;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class GetHardwaresResponse {
    @Singular
    private List<GetHardwareResponse> hardwares;
}
