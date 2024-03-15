package org.example.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
public class GetCompaniesResponse {
    @Singular
    private List<GetCompanyResponse> companies;
}
