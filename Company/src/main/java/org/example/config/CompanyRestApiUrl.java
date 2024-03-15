package org.example.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CompanyRestApiUrl {
    @Value("${isa.company.url.delete}")
    private String deleteUrl;
    @Value("${isa.company.url.put}")
    private String putUrl;
    @Value("${isa.company.url.post}")
    private String postUrl;
}
