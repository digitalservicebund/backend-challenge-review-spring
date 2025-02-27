package de.digitalservice.backendchallenge.dashboard.departments;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentsService {
    private final ObjectMapper objectMapper;

    @Value("classpath:departments.json")
    private Resource departmentsFileResource;

    public DepartmentsService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Department> readDepartmentsFromFile() throws IOException {
        DepartmentsFileContent departmentsFileContent = objectMapper.readValue(departmentsFileResource.getFile(),
                DepartmentsFileContent.class);
        return departmentsFileContent.getDepartments();
    }

    /**
     * This method maps the organization names of all departments and their subordinates to the corresponding department.
     * @param departments Given list of departments
     * @return A map containing all organization names mapped to the corresponding department.
     */
    public HashMap<String, Department> mapOrganizationNamesToDepartments(List<Department> departments) {
        HashMap<String, Department> orgNameToDepartment = new HashMap<>();
        System.out.println("mapping");
        System.out.println(departments);
        for (Department department : departments) {
            orgNameToDepartment.put(department.getName(), department);
            for (Department.Subordinate subordinate : department.getSubordinates()) {
                orgNameToDepartment.put(subordinate.getName(), department);
            }
        }
        System.out.println(departments);
        return orgNameToDepartment;
    }
}
