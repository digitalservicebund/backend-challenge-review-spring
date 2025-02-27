package de.digitalservice.backendchallenge.dashboard.departments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Department implements Comparable<Department> {
    private String name;
    private String abbr;
    private List<Subordinate> subordinates = new ArrayList<>();
    @JsonIgnore
    private int dataSetCount = 0;

    public Department(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Subordinate {
        private String name;
        private String abbr;
    }

    public void increaseDataSetCount(int increaseBy) {
        dataSetCount += increaseBy;
    }

    @Override
    public int compareTo(Department other) {
        return other.dataSetCount - this.dataSetCount;
    }
}
