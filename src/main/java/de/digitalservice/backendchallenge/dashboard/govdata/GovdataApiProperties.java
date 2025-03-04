package de.digitalservice.backendchallenge.dashboard.govdata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties("govdata-api")
@Validated
@Data
public class GovdataApiProperties {
    @NotEmpty
    private String baseUrl;
}
