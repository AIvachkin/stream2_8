package pro.sky.stream2_8.model.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.stream2_8.exception.EmployeeAlreadyAddedException;
import pro.sky.stream2_8.exception.EmployeeNotFoundException;
import pro.sky.stream2_8.exception.EmployeeStorageIsFullException;
import pro.sky.stream2_8.exception.InvalidInputException;
import pro.sky.stream2_8.model.Employee;


import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private String getKey(String name,
                          String surname) {
        return name + surname;
    }

    public Employee addEmployee(String name,
                                String surname,
                                int department,
                                double salary) {
        if (!validateInput(name, surname)) {
            throw new InvalidInputException();
        } else {

//            Employee employee = new Employee(capitalize(name), capitalize(surname), department, salary);
//            String key = getKey(capitalize(name), capitalize(surname));
            Employee employee = new Employee(name, surname, department, salary);
            String key = getKey(name, surname);
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException();
            }

            if (employees.size() < LIMIT) {
                employees.put(key, employee);
                return employee;
            }
            throw new EmployeeStorageIsFullException();
        }
//        throw new EmployeeAlreadyAddedException();
    }

    public Employee findEmployee(String name, String surname) {
        if (!validateInput(name, surname)) {
            throw new InvalidInputException();
        }

        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public Employee removeEmployee(String name, String surname) {
        if (!validateInput(name, surname)) {
            throw new InvalidInputException();
        }

        String key = getKey(name, surname);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

private boolean validateInput (String name, String surname) {
        return isAlpha(name)&& isAlpha(surname)&&!name.isEmpty()&&!surname.isEmpty() ;


}
//    public List<Employee> printEmployeesByDepartment(int department) {
//        return employees.values().stream()
//                .filter(e -> e.getDepartment()==department)
//                .collect(Collectors.toList());
//
//    }
}
