package de.digitalservice.backendchallenge.dashboard.govdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Slf4j
public class GovdataService {
    private final WebClient client;

    public GovdataService(GovdataApiProperties apiProperties) {
        client = WebClient.create(apiProperties.getBaseUrl());
    }

    public List<Organization> fetchOrganizations() {
        OrganizationListResponse response = client.get()
                .uri("/action/organization_list?all_fields=true&include_dataset_count=true")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(OrganizationListResponse.class)
                .block();

        return response.getResult();
    }
}
