package pro.sky.stream2_8.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {
    @JsonProperty("firstname")
    private final String name;

    @JsonProperty("lastname")
    private final String surname;

    private final double salary;
    private final int department;


    public Employee(String name,
                    String surname,
                    int department,
                    double salary) {
        this.name = StringUtils.capitalize(name.toLowerCase());
        this.surname = StringUtils.capitalize(surname.toLowerCase());
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name,
                surname,
                department,
                salary);
    }

    @Override
    public String toString() {
        return String.format(
                "ФИО: %s %s, отдел: %d, ЗП: %.2f",
                surname,
                name,
                department,
                salary
        );
    }
}
