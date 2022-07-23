package pro.sky.stream2_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.stream2_8.model.Employee;
import pro.sky.stream2_8.model.service.DepartmentService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.maxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee minSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.minSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> findEmployeesFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeesFromDepartment(department);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployees();
    }

}


