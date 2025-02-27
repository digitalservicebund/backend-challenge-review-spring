package de.digitalservice.backendchallenge.dashboard.govdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private String title;
    @JsonProperty("package_count")
    private int dataSetCount;
}
