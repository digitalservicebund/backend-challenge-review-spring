package de.digitalservice.backendchallenge.dashboard.departments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentsFileContent {
    private List<Department> departments = new ArrayList<>();
}
