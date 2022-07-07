package pro.sky.stream2_8.model.service;

import org.springframework.stereotype.Service;
import pro.sky.stream2_8.exception.EmployeeAlreadyAddedException;
import pro.sky.stream2_8.exception.EmployeeNotFoundException;
import pro.sky.stream2_8.exception.EmployeeStorageIsFullException;
import pro.sky.stream2_8.model.Employee;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);

        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees) ;
    }
}