package de.digitalservice.backendchallenge.dashboard;

import org.springframework.stereotype.Service;

import de.digitalservice.backendchallenge.dashboard.departments.Department;
import de.digitalservice.backendchallenge.dashboard.departments.DepartmentsService;
import de.digitalservice.backendchallenge.dashboard.govdata.GovdataService;
import de.digitalservice.backendchallenge.dashboard.govdata.Organization;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class DashboardService {
    private final GovdataService govdataService;
    private final DepartmentsService departmentsService;

    public DashboardService(GovdataService govdataService, DepartmentsService departmentsService) {
        this.govdataService = govdataService;
        this.departmentsService = departmentsService;
    }

    /**
     * This method fetches all organizations from the Govdata API, reads all relevant departments from file and
     * counts the total number of datasets per department.
     * @return A list of departments with the total number of datasets published by the department or their subordinates
     */
    public List<Department> getDepartmentsWithDataSetCount() throws IOException {
        List<Organization> organizations = govdataService.fetchOrganizations();
        List<Department> relevantMinistries = departmentsService.readDepartmentsFromFile();

        HashMap<String, Department> orgNameToDepartment = departmentsService.mapOrganizationNamesToDepartments(relevantMinistries);
        orgNameToDepartment = updateDatasetCounts(organizations, orgNameToDepartment);

        return relevantMinistries;
    }

    public HashMap<String, Department> updateDatasetCounts(List<Organization> organizations,  HashMap<String, Department> orgNameToDepartment) {
        for(Organization organization : organizations) {
            Department department = orgNameToDepartment.get(organization.getTitle());
            if (department != null) {
                department.increaseDataSetCount(organization.getDataSetCount());
            }
        }
        return orgNameToDepartment;
    }

    
}
