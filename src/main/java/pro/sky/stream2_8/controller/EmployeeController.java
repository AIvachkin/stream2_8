package pro.sky.stream2_8.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.stream2_8.model.Employee;
import pro.sky.stream2_8.model.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname,
                                @RequestParam("departmentId") int department,
                                @RequestParam("salary") double salary) {
        return employeeService.addEmployee(name, surname, department, salary);

    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String name,
                                 @RequestParam("lastName") String surname) {
        return employeeService.findEmployee(name, surname);

    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                   @RequestParam("lastName") String surname) {
        return employeeService.removeEmployee(name, surname);

    }

    @GetMapping("/all")
    public List<Employee> getAll() {

        return employeeService.getAll();
    }

//    @GetMapping("/departmentId")
//    public String printEmployeesByDepartment(@RequestParam("departmentId") int department) {
//        final List<Employee> employeesByDepartment = employeeService.printEmployeesByDepartment(department);
//        final List<String> departments = new ArrayList<>();
//
//        final List<Integer> streamDepartments = employeesByDepartment.stream()
//                .map(Employee::getDepartment)
//                .collect(Collectors.toList());
//        return streamDepartments.toString();
//    }
}
