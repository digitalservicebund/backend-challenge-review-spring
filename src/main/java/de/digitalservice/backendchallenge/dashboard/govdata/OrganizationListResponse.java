package de.digitalservice.backendchallenge.dashboard.govdata;

import lombok.Data;

import java.util.List;

@Data
public class OrganizationListResponse {
    private List<Organization> result;
}
