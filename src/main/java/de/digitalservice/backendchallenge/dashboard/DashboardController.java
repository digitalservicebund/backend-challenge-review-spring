package de.digitalservice.backendchallenge.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import de.digitalservice.backendchallenge.dashboard.departments.Department;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @ExceptionHandler(IOException.class)
    public String handleIOException(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }

    @GetMapping("/")
    public String showDashboard(Model model) throws IOException {
        List<Department> departments = dashboardService.getDepartmentsWithDataSetCount();
        Collections.sort(departments);
        model.addAttribute("departments", departments);
        return "dashboard";
    }
}
