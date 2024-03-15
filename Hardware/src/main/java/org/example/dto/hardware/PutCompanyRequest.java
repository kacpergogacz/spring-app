package org.example.dto.hardware;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutCompanyRequest {
    private String name;

}
