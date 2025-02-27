package de.digitalservice.backendchallenge.dashboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DashboardIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void dashboardDisplayedWithoutErrors() throws Exception {
        // Given

        // When
        ResultActions result = mockMvc.perform(get("/"));

        // Then
        result.andExpect(status().is2xxSuccessful());
        result.andExpect(content().string(containsString("Number of Datasets Published by Federal Ministries")));
        result.andExpect(content().string(containsString("<table class=\"table table-hover\">"))); // at least one department displayed
    }
}